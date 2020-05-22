package com.rizze.beans.labs.sof;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class SaxTest {

    public static Logger logger = LoggerFactory.getLogger(SaxTest.class);


    public class SaxProcess implements ContentHandler {

        private boolean start= false;
        private static final String START_ITEM = "payload";
        private String result = "";

        @Override
        public void characters(char[] ch, int begin, int length) throws SAXException {
            if(start == true){
                logger.debug("STRING : "+new String(ch).substring(begin,begin+length));

                result+=new String(new String(ch).substring(begin,begin+length));
            }
        }

        @Override
        public void endDocument() throws SAXException {
                        logger.debug("end document");
        }

        @Override
        public void endElement(String uri, String localName, String name) throws SAXException {

            if(name!=null && name.compareToIgnoreCase(START_ITEM)==0){
                start = false;
            }
            else{
                if(start == true){
                    logger.debug("END - "+ localName + " - " + name);
                    result+="</"+name+">";
                }
            }


        }

        @Override
        public void endPrefixMapping(String prefix) throws SAXException {



        }

        @Override
        public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {

        }

        @Override
        public void processingInstruction(String target, String data) throws SAXException {


        }

        @Override
        public void setDocumentLocator(Locator locator) {

        }

        @Override
        public void skippedEntity(String name) throws SAXException {


        }

        @Override
        public void startDocument() throws SAXException {
            start=false;
            result = "";

            logger.debug("start document");
        }

        @Override
        public void startElement(String uri, String localName, String name, Attributes atts) throws SAXException {

            if(name!=null && name.compareToIgnoreCase(START_ITEM)==0){
                start = true;
            }
            else{

                if(start == true){
                    //if already started ... go on
                    logger.debug("START - "+ localName + " - " + name);
                    result+="<"+name+">";
                }
            }


        }

        @Override
        public void startPrefixMapping(String prefix, String uri) throws SAXException {


        }

        /**
         * return resulting string
         * @return
         */
        public String getResult(){
            return result;
        }

    }





    @Test
    public void test() {


        String xml = "<root><meta><elememtA>xx</elememtA></meta><payload><parent><child1>a</child1></parent><parent><child1>b</child1></parent></payload></root>";
        InputSource in = new InputSource(new StringReader(xml));


            try {
                XMLReader  reader= SAXParserFactory.newInstance().newSAXParser().getXMLReader();
                SaxProcess p=new SaxProcess();
                reader.setContentHandler(p);
                reader.parse(in);
                logger.info("RESULT \n"+p.getResult());
            } catch (ParserConfigurationException | SAXException | IOException e) {
                e.printStackTrace();
            }

    }

}