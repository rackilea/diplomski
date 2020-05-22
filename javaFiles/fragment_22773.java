import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import org.kabeja.dxf.DXFDocument;
import org.kabeja.parser.*;
import org.kabeja.parser.ParserBuilder;
import org.kabeja.svg.SVGGenerator;
import org.kabeja.xml.*;

public class MyClass {

    public static void main(String[] args) {
        MyClas x=new MyClas();
        x.parseFile("C:\\Users\\Space\\Desktop\\test2.dxf");
    }

    public void parseFile(String sourceFile) {
        try {
            FileOutputStream o=new FileOutputStream("C:\\Users\\Space\\Desktop\\test2.png");
            InputStream in = new FileInputStream(sourceFile);//your stream from upload or somewhere
            Parser dxfParser = ParserBuilder.createDefaultParser();
            dxfParser.parse(in, "");
            DXFDocument doc = dxfParser.getDocument();
            SVGGenerator generator = new SVGGenerator();
            //org.xml.sax.InputSource out = SAXPNGSerializer;
            SAXSerializer out = new org.kabeja.batik.tools.SAXPNGSerializer();
            out.setOutput(o);
            generator.generate(doc,out,new HashMap());
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception ioe) {
            ioe.printStackTrace();
        }
    }

}