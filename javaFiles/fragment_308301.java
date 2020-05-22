import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class Demo {

    public static void main(String[] args) throws Exception  {
        JAXBContext jc = JAXBContext.newInstance(ExecutionReport.class);

        ExecutionReport er = new ExecutionReport();
        er.setAccount("account_data");
        er.setSenderCompID("sender");

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(er, System.out);
    }

}