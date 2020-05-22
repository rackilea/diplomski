package XXX; 

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import java.util.Date;


public class XMLGregorianCalendarXmlAdapter extends XmlAdapter<String, XMLGregorianCalendar>{

@Override
public XMLGregorianCalendar unmarshal(String v) throws Exception {
    if(v==null ||  v.trim().isEmpty()) {
        return null;
    }
    return DatatypeFactory.newInstance().newXMLGregorianCalendar(v);
}

@Override
public String marshal(XMLGregorianCalendar v) throws Exception {
    return v==null ? null : /*do something with the XMLGregorianCalendar */;
}

}