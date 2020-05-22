import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.x509.CertificatePolicies;
import org.bouncycastle.asn1.x509.PolicyInformation;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/**
 * 2016 krzysiek
 */
public class App {
    private static final String CERTIFICATE_POLICY_OID = "2.5.29.32";

    private static final String FILENAME = "/test.cer";

    public static void main(String[] args) {
        try {
            X509Certificate cert = loadCertificate();
            String policyIdentifier = getCertificatePolicyId(cert, 0, 0);

            System.out.println("Policy Identifier: " + policyIdentifier);

            String subjectType = getSubjectType(cert);
            System.out.println("Subject Type: " + subjectType);
        } catch (Exception e) {
            System.out.println("Problem with certificate: " + e.getMessage());
        }
    }

    private static String getSubjectType(X509Certificate cert) {
        int pathLen = cert.getBasicConstraints();
        if (pathLen == -1) {
            if (cert.getKeyUsage()[5] || cert.getKeyUsage()[6]) { //simple check, there my be needed more key usage and extended key usage verification
                return "Service";
            } else {
                return "EndEntity";
            }

        } else {
            try {
                cert.verify(cert.getPublicKey());
                return "RootCA";
            } catch (SignatureException | InvalidKeyException e) {
                return "SubCA";
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static X509Certificate loadCertificate() {
        try (InputStream in = new FileInputStream(App.class.getResource(FILENAME).getFile())) {
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            Certificate certificate = cf.generateCertificate(in);
            X509Certificate cert = (X509Certificate) certificate;

            return cert;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getCertificatePolicyId(X509Certificate cert, int certificatePolicyPos, int policyIdentifierPos)
            throws IOException {
        byte[] extPolicyBytes = cert.getExtensionValue(CERTIFICATE_POLICY_OID);
        if (extPolicyBytes == null) {
            return null;
        }

        DEROctetString oct = (DEROctetString) (new ASN1InputStream(new ByteArrayInputStream(extPolicyBytes)).readObject());
        ASN1Sequence seq = (ASN1Sequence) new ASN1InputStream(new ByteArrayInputStream(oct.getOctets())).readObject();

        if (seq.size() <= (certificatePolicyPos)) {
            return null;
        }

        CertificatePolicies certificatePolicies = new CertificatePolicies(PolicyInformation.getInstance(seq.getObjectAt(certificatePolicyPos)));
        if (certificatePolicies.getPolicyInformation().length <= policyIdentifierPos) {
            return null;
        }

        PolicyInformation[] policyInformation = certificatePolicies.getPolicyInformation();
        return policyInformation[policyIdentifierPos].getPolicyIdentifier().getId();
    }
}