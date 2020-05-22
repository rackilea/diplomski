import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.DERSequence;

import javax.xml.bind.DatatypeConverter;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws Exception {
        BigInteger r = new BigInteger("29128391823901823918293108120938102381912839182390182391829310812093810238199");
        BigInteger s = new BigInteger("38663726871681756650018917824777578348866372687168175665001891782477757834811");

        ASN1Integer asn1R = new ASN1Integer(r);
        ASN1Integer asn1S = new ASN1Integer(s);

        DERSequence seq = new DERSequence(new ASN1Integer[]{asn1R, asn1S});
        byte[] encoded = seq.getEncoded();
        System.out.println(DatatypeConverter.printHexBinary(encoded));
    }
}