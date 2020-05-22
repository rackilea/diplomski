import org.apache.axis.AxisFault;
import org.apache.axis.SOAPPart;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.message.SOAPEnvelope;
import org.apache.axis.soap.MessageFactoryImpl;
....
String mHostAddr = "yourURL";
try {

        String envelope = getXML(); //redFromXmlFile();
        //String envelope = "";
        byte[] reqBytes = envelope.getBytes();
        ByteArrayInputStream bis = new ByteArrayInputStream(reqBytes);
        StreamSource ss = new StreamSource(bis);

        //Create a SOAP Message Object
        MessageFactoryImpl messageFactory = new MessageFactoryImpl();
        SOAPMessage msg = messageFactory.createMessage();
        SOAPPart soapPart = (SOAPPart) msg.getSOAPPart();

        //Set the soapPart Content with the stream source
        soapPart.setContent(ss);

        //Create a WebService Call
        Service service = new Service();
        Call call = (Call)service.createCall();
        call.setTargetEndpointAddress(mHostAddr);

        //Invoke the WebService.
        SOAPEnvelope resp = call.invoke(((org.apache.axis.SOAPPart)soapPart).getAsSOAPEnvelope());






    } catch (AxisFault ex) {
        System.out.println(ex.getMessage());
    } catch (ServiceException ex) {
        System.out.println(ex.getMessage());
    } catch (SOAPException ex) {
        System.out.println(ex.getMessage());
    } catch (RemoteException e) {
        e.printStackTrace();
    } 


....