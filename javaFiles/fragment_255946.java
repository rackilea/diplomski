public class XMLSender {

 public static void send(Document tosend, OutputStream channel) throws   TransformerConfigurationException, IOException {
     XMLOutputStream out = new XMLOutputStream(channel);

     StreamResult sr = new StreamResult(out);
     DOMSource ds = new DOMSource(tosend);
     Transformer tf = TransformerFactory.newInstance().newTransformer();

     try {
         tf.transform(ds, sr);
     } catch (TransformerException ex) {
         Logger.getLogger(XMLSender.class.getName()).log(Level.SEVERE, null, ex);
     }

     out.send();
 }
}