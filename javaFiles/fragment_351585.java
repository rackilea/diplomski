import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class PersisterAppointment {

    private static String APPOINTMENT_FILE_NAME = "Appointments.xml"; 

    public static void main(String args[]){
        PersisterAppointment demo = new PersisterAppointment();
        try {
            demo.persistAppointment("Edgard","Rendón",Calendar.getInstance(),"Title field","Description field","row field","column field");
            demo.persistAppointment("Brandon","Ramirez",Calendar.getInstance(),"Title field","Description field","row field","column field");
        } catch (ParserConfigurationException | TransformerException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isAppointment(){
        File file = new File(APPOINTMENT_FILE_NAME);
        return file.exists();
    }

    public void persistAppointment(String iname, String ilastname, Calendar calendar, String ititle, String idescription, String irow, String icolumn) throws ParserConfigurationException, TransformerException, SAXException, IOException{
        DocumentBuilderFactory docfactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docbuilder = docfactory.newDocumentBuilder();
        Document doc;

        if(isAppointment()){
            InputStream is = new FileInputStream(APPOINTMENT_FILE_NAME);
            doc = docbuilder.parse(is);
        }else{
            doc = docbuilder.newDocument();
        }

        TransformerFactory tfactory = TransformerFactory.newInstance();
        Transformer transformer = tfactory.newTransformer();


        Source source = new DOMSource(doc);
        File file = new File(APPOINTMENT_FILE_NAME);


        Element appointment = doc.createElement("appointment");
        doc.appendChild(appointment);


        Element ename = doc.createElement("name");
        Element elastname = doc.createElement("lastname");
        Element eday = doc.createElement("day");
        Element emonth = doc.createElement("month");
        Element eyear = doc.createElement("year");
        Element ehour = doc.createElement("hour");
        Element etitle = doc.createElement("title");
        Element edescription = doc.createElement("description");
        Element erow = doc.createElement("row");
        Element ecolumn = doc.createElement("column");

        Text tname = doc.createTextNode(iname);
        Text tlastname = doc.createTextNode(ilastname);
        Text tday = doc.createTextNode(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
        Text tmonth = doc.createTextNode(String.valueOf(calendar.get(Calendar.MONTH)));
        Text tyear = doc.createTextNode(String.valueOf(calendar.get(Calendar.YEAR)));
        Text thour = doc.createTextNode(String.valueOf(calendar.get(Calendar.HOUR_OF_DAY)));
        Text ttitle = doc.createTextNode(ititle);
        Text tdescription = doc.createTextNode(idescription);
        Text trow = doc.createTextNode(irow);
        Text tcolumn = doc.createTextNode(icolumn);


        ename.appendChild(tname);
        elastname.appendChild(tlastname);
        eday.appendChild(tday);
        emonth.appendChild(tmonth);
        eyear.appendChild(tyear);
        ehour.appendChild(thour);
        etitle.appendChild(ttitle);
        edescription.appendChild(tdescription);
        erow.appendChild(trow);
        ecolumn.appendChild(tcolumn);

        appointment.appendChild(ename);
        appointment.appendChild(elastname);
        appointment.appendChild(eday);
        appointment.appendChild(emonth);
        appointment.appendChild(eyear);
        appointment.appendChild(ehour);
        appointment.appendChild(etitle);
        appointment.appendChild(edescription);
        appointment.appendChild(erow);
        appointment.appendChild(ecolumn);

        StreamResult result = new StreamResult(file);

            transformer.transform(source, result);
        }
    }
}