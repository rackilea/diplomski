import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.openssl.jcajce.JcaPEMWriter;

// ... used the same code you posted above ...

// *** NOTE: if you want a detached signature, change the second parameter to false ***
CMSSignedData sigData = gen.generate(msg, false);

// write sigData to output.pem file, using a pem writer
ContentInfo ci = ContentInfo.getInstance(ASN1Sequence.fromByteArray(sigData.getEncoded()));
JcaPEMWriter writer = new JcaPEMWriter(new FileWriter("output.pem"));
writer.writeObject(ci);
writer.close();