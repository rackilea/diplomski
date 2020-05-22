import java.net.URL;

public class Main {
    public static void main(String[] args) throws Exception{
        URL qaWsdl = new URL("http://tsteportal.posta.si/Services/eSpremnica.Wcf/eOddaja.svc");
        URL prodWsdl = new URL("https://eportal.posta.si/Services/eSpremnica.Wcf/eOddaja.svc");

        boolean isQA = Boolean.valueOf(args[0]);

        //Pass whichever WSDL endpoint you need
        EchoService service = new EchoService((isQA) ? qaWsdl : prodWsdl);

        Echo port = service.getEchoPort();
    }
}