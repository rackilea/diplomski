public class WsTest {

    public static void main(String[] args) {
        try {
            CheckTinService checkTinService = new CheckTinService();
            CheckTinPortType portType = checkTinService.getPort(CheckTinPortType.class);
            Holder<String> code = new Holder<String>("DE");
            Holder<String> tin = new Holder<String>("12346789");
            Holder<XMLGregorianCalendar> requestDate = new Holder<>();
            Holder<Boolean> validStructure = new Holder<>();
            Holder<Boolean> validSyntax = new Holder<>();
            portType.checkTin(code, tin, requestDate, validStructure, validSyntax);

            System.out.println("requestDate : " + requestDate.value);
            System.out.println("validStructure : " + validStructure.value);
            System.out.println("validSyntax : " + validSyntax.value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}