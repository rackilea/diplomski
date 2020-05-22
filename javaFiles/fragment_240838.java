import java.util.*;
import java.io.*;
import java.security.KeyStore;
import java.security.KeyStore.PrivateKeyEntry;
import java.security.cert.X509Certificate;
import javax.xml.crypto.dsig.*;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.*;
import javax.xml.crypto.dsig.spec.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;

public class XMLSigner {

    public static void signXmlDocumentOnDisk(String fileToBeSignedPath, String signedFileSavePath, String pkcs12CertificateFilePath, String password) throws Exception {
        XMLSignatureFactory fac = getXMLSignatureFactory();
        Reference ref = getSHA1WholeDocumentEnvelopedTransformReference(fac);
        SignedInfo si = getSignedInfo(fac, ref);
        PrivateKeyEntry keyEntry = loadPKCS12KeyStoreAndGetSigningKeyEntry(pkcs12CertificateFilePath, password);
        KeyInfo ki = getKeyInfoWithX509Data(keyEntry, fac);
        Document doc = instantiateDocumentToBeSigned(fileToBeSignedPath);
        signDocumentAndPlaceSignatureAsFirstChildElement(doc, keyEntry, fac, si, ki);
        writeResultingDocument(doc, signedFileSavePath);
    }

    private static XMLSignatureFactory getXMLSignatureFactory() {
        return XMLSignatureFactory.getInstance("DOM");
    }

    private static Reference getSHA1WholeDocumentEnvelopedTransformReference(XMLSignatureFactory fac) throws Exception {
        return 
            fac.newReference(
                "", 
                fac.newDigestMethod(DigestMethod.SHA1, null),
                Collections.singletonList(fac.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null)),
                null, 
                null
            );
    }

    private static SignedInfo getSignedInfo(XMLSignatureFactory fac, Reference ref) throws Exception {
        return 
            fac.newSignedInfo(
                fac.newCanonicalizationMethod(
                    CanonicalizationMethod.INCLUSIVE, 
                    (C14NMethodParameterSpec) null
                ),
                fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null),
                Collections.singletonList(ref)
            );
    }

    private static PrivateKeyEntry loadPKCS12KeyStoreAndGetSigningKeyEntry(String pkcs12CertificateFilePath, String password) throws Exception {
        KeyStore ks = KeyStore.getInstance("PKCS12");
        ks.load(new FileInputStream(pkcs12CertificateFilePath), password.toCharArray());    
        return (PrivateKeyEntry)ks.getEntry(ks.aliases().nextElement(), new KeyStore.PasswordProtection(password.toCharArray()));           
    }

    private static KeyInfo getKeyInfoWithX509Data(PrivateKeyEntry keyEntry, XMLSignatureFactory fac) {
        X509Certificate cert = (X509Certificate) keyEntry.getCertificate();
        KeyInfoFactory kif = fac.getKeyInfoFactory();
        List x509Content = new ArrayList();
        x509Content.add(cert.getSubjectX500Principal().getName());
        x509Content.add(cert);
        X509Data xd = kif.newX509Data(x509Content);
        return kif.newKeyInfo(Collections.singletonList(xd));
    }

    private static Document instantiateDocumentToBeSigned(String fileToBeSignedPath) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        return dbf.newDocumentBuilder().parse(new FileInputStream(fileToBeSignedPath));
    }

    private static void signDocumentAndPlaceSignatureAsFirstChildElement(Document doc, PrivateKeyEntry keyEntry, XMLSignatureFactory fac, SignedInfo si, KeyInfo ki) throws Exception {
        DOMSignContext dsc = new DOMSignContext(keyEntry.getPrivateKey(), doc.getDocumentElement(), doc.getDocumentElement().getFirstChild());
        XMLSignature signature = fac.newXMLSignature(si, ki);
        signature.sign(dsc);
    }

    private static void writeResultingDocument(Document doc, String signedFileSavePath) throws Exception {
        OutputStream os = new FileOutputStream(signedFileSavePath);
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer trans = tf.newTransformer();
        trans.transform(new DOMSource(doc), new StreamResult(os));
    }
}