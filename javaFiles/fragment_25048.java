import java.io.File;
import java.io.IOException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class MyClass {

    public static void main(String[] args) {

        try {
            validateFile(new File("Test.xml") , new  File("Test.xsd"));
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    private static void validateFile(File xmlFile, File xsdFile) throws SAXException, IOException
    {
        SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/XML/XMLSchema/v1.1");
        File schemaLocation = xsdFile;
        Schema schema = factory.newSchema(schemaLocation);
        Validator validator = schema.newValidator();
        Source source = new StreamSource(xmlFile);
        try
        {
            validator.validate(source);
            System.out.println(xmlFile.getName() + " is valid.");
        }
        catch (SAXException ex)
        {
            System.out.println(xmlFile.getName() + " is not valid because ");
            System.out.println(ex.getMessage());
        }
    }
}