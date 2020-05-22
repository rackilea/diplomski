package rngdatatype;

import com.thaiopensource.validate.SchemaReader;
import com.thaiopensource.validate.ValidationDriver;
import com.thaiopensource.validate.auto.AutoSchemaReader;
import java.io.File;
import java.io.IOException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class JingApi {

    public static void main(String[] args) throws SAXException, IOException {
        String rng = args[0];
        String xml = args[1];
        File rngFile = new File(rng);
        File xmlFile = new File(xml);

        SchemaReader sr = new AutoSchemaReader();
        ValidationDriver driver = new ValidationDriver(sr);
        InputSource inRng = ValidationDriver.fileInputSource(rngFile);
        inRng.setEncoding("UTF-8");
        driver.loadSchema(inRng);
        InputSource inXml = ValidationDriver.fileInputSource(xmlFile);
        inXml.setEncoding("UTF-8");
        driver.validate(inXml);
    }
}