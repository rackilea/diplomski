import com.thoughtworks.xstream.XStream;

 public static String writeToXml(Object objectToWrite) {
        XStream  xstream   = new XStream();
        return xstream.toXML(objectToWrite);
    }