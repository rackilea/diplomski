import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPublicKey;
import javax.xml.bind.DatatypeConverter;

public class RSAToXML {

    public static void main(String[] args) throws Exception {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(1024);
        KeyPair keyPair = kpg.generateKeyPair();
        RSAPublicKey rsaPub = (RSAPublicKey) keyPair.getPublic();
        System.out.println("<RSAKeyValue>");
        System.out.print("\t<Modulus>");
        System.out.print(DatatypeConverter.printBase64Binary(rsaPub.getModulus().toByteArray()));
        System.out.println("</Modulus>");
        System.out.print("\t<Exponent>");
        System.out.print(DatatypeConverter.printBase64Binary(rsaPub.getPublicExponent().toByteArray()));
        System.out.println("</Exponent>");
        System.out.println("</RSAKeyValue>");
    }
}