package com.technoroy.examples.guava;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * The primary executable class
 * 
 * @author Rahul R
 *
 */
public class GuavaCacheProcessor {
    private final static BlockingQueue<Integer> notificationQueue = new LinkedBlockingQueue<>();

    public static void main(String... arguments) {
        Runnable xmlProcessor = new Runnable() {
            public void run() {
                parseDataFile();
            }
        };

        Runnable mdlGenerator = new Runnable() {
            public void run() {
                try {
                    while (true) {
                        Integer id = notificationQueue.take();
                        Employee record = ApplicationCacheUtil.getRecord(id);
                        generateContent(record);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(xmlProcessor);
        executorService.submit(mdlGenerator);
    }

    public static void generateContent(Employee employee) {
        System.out.println(employee);
    }

    public static void parseDataFile() {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        InputStream dataInputStream = GuavaCacheProcessor.class.getResourceAsStream("employee-records.xml");

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            saxParser.parse(dataInputStream, new DefaultHandler() {
                private Employee employee = null;
                private StringBuilder elementValue = null;

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes)
                        throws SAXException {
                    if (qName.equalsIgnoreCase("Employee")) {
                        employee = new Employee();

                        String id = attributes.getValue("id");
                        if (id.matches("-?\\d+(\\.\\d+)?")) {
                            employee.setId(Integer.valueOf(id));
                        }
                    }

                    elementValue = new StringBuilder();
                }

                @Override
                public void characters(char ch[], int start, int length) throws SAXException {
                    if (elementValue != null) {
                        elementValue.append(new String(ch, start, length));
                    }
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if (qName.equalsIgnoreCase("name")) {
                        if (employee != null && elementValue != null) {
                            employee.setName(elementValue.toString());
                        }
                    } else if (qName.equalsIgnoreCase("Employee")) {
                        ApplicationCacheUtil.putRecord(employee.getId(), employee);
                        try {
                            notificationQueue.put(employee.getId());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    elementValue = null;
                }
            });
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 * The Cache utilities class, that initializes and returns a handle to the
 * cache.
 * 
 * @author Rahul R
 *
 */
class ApplicationCacheUtil {
    private static Cache<Integer, Employee> cache = CacheBuilder.newBuilder().build();

    public static Cache<Integer, Employee> getCache() {
        return cache;
    }

    public static void putRecord(Integer key, Employee value) {
        cache.put(key, value);
    }

    public static Employee getRecord(Integer key) {
        return cache.getIfPresent(key);
    }
}