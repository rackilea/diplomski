package nl.owlstead.stackoverflow;

import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.Security;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x9.ECNamedCurveTable;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.params.ECNamedDomainParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.util.encoders.Hex;

public class BC_EC_KeyCreator {

    public static void main(String[] args) throws Exception {

        String name = "secp256r1";

        // === NOT PART OF THE CODE, JUST GETTING TEST VECTOR ===
        Security.addProvider(new BouncyCastleProvider());
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("EC", "BC");
        kpg.initialize(new ECGenParameterSpec(name));
        ECPublicKey key = (ECPublicKey) kpg.generateKeyPair().getPublic();
        byte[] x = key.getW().getAffineX().toByteArray();
        byte[] y = key.getW().getAffineY().toByteArray();

        // assumes that x and y are (unsigned) big endian encoded
        BigInteger xbi = new BigInteger(1, x);
        BigInteger ybi = new BigInteger(1, y);
        X9ECParameters x9 = ECNamedCurveTable.getByName(name);
        ASN1ObjectIdentifier oid = ECNamedCurveTable.getOID(name);
        ECCurve curve = x9.getCurve();
        ECPoint point = curve.createPoint(xbi, ybi);
        ECNamedDomainParameters dParams = new ECNamedDomainParameters(oid,
                x9.getCurve(), x9.getG(), x9.getN(), x9.getH(), x9.getSeed());
        ECPublicKeyParameters pubKey = new ECPublicKeyParameters(point, dParams);
        System.out.println(pubKey);

        // some additional encoding tricks
        byte[] compressed = point.getEncoded(true);
        System.out.println(Hex.toHexString(compressed));
        byte[] uncompressed = point.getEncoded(false);
        System.out.println(Hex.toHexString(uncompressed));
    }
}