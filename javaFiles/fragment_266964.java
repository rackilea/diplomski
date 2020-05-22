import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class Sha1Test {

    public static void main(String args[]) throws Exception {
        String data = "<wsu:Timestamp xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\" wsu:Id=\"TS-f3c103e9-1897-43d8-8cf6-274bdb647678\"><wsu:Created>2016-02-24T15:32:12.693Z</wsu:Created><wsu:Expires>2016-02-24T15:37:12.693Z</wsu:Expires></wsu:Timestamp>";
        printShaDigest(data);
    }

    static void printShaDigest(String data) {
        System.out.println("data = " + data);
        System.out.println("sha1 = " + new String(Base64.encodeBase64(DigestUtils.sha1(data.getBytes()))));
    }

}