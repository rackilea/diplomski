import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Stack;

import javax.xml.XMLConstants;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParserDemo {
    public static void main(String[] args) {
        Schema schema;
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory schemaFactory = SchemaFactory.newInstance(language);

        try {
            schema = schemaFactory.newSchema(new File("src/newEmployee.xsd")); // create new xml schema
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setSchema(schema);  // set schema to the factory

            InputStream xmlInput = new FileInputStream("src/empl.xml");
            SAXParser saxParser = factory.newSAXParser();
            SaxHandler handler = new SaxHandler();
            saxParser.parse(xmlInput, handler);

            for (Employee employee : handler.employees) {
                System.out.println(employee.getName());
                System.out.println(employee.getSalary());
                System.out.println(employee.getHireDate());
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}

class SaxHandler extends DefaultHandler {

    private Stack<String> elementStack = new Stack<String>();
    private Stack<Object> objectStack = new Stack<Object>();

    public List<Employee> employees = new ArrayList<Employee>();
    Employee employee=null;
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        this.elementStack.push(qName);

        if ("employee".equals(qName)) {

            if(employee!=null)
            {
                  this.employees.add(employee);
            }
             employee = new Employee();
            this.objectStack.push(employee);

        }
        if("hiredate".equals(qName))
        {
             String yearatt=attributes.getValue("year");
             System.out.println(yearatt);
             String monthatt=attributes.getValue("month");
             System.out.println(monthatt);
             String dayatt=attributes.getValue("day");
             System.out.println(dayatt);
             employee.setHireDay( yearatt,  monthatt,  dayatt) ;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        this.elementStack.pop();

        if ("employee".equals(qName)) {
            Object objects = this.objectStack.pop();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length).trim();
        if (value.length() == 0) return;        // skip white space

        if ("name".equals(currentElement())) {
             employee = (Employee) this.objectStack.peek();
            employee.setName(value);
        } else if ("salary".equals(currentElement()) && "employee".equals(currentParrentElement())) {

            employee.setSalary(Double.parseDouble(value));
        } else if ("hiredate".equals(currentElement()) && "employee".equals(currentParrentElement())) {



            // I stuck here 
//            employee.setHireDay();
        }
    }

    private String currentElement() {
        return this.elementStack.peek();
    }

    private String currentParrentElement() {
        if (this.elementStack.size() < 2) return null;
        return this.elementStack.get(this.elementStack.size() - 2);
    }