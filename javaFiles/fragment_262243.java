package de.roland_illig.crypto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.Security;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import org.apache.commons.io.IOUtils;
import org.bouncycastle.cms.CMSEnvelopedDataStreamGenerator;
import org.bouncycastle.cms.CMSEnvelopedGenerator;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class CryptDemo {

  private static final File DIR = new File("c:/program files/cygwin/home/roland/crypto/");

  private static X509Certificate certificate() throws IOException, GeneralSecurityException {
    InputStream is = new FileInputStream(new File(DIR, "key.pub.der"));
    CertificateFactory cf = CertificateFactory.getInstance("X.509");
    X509Certificate cert = (X509Certificate) cf.generateCertificate(is);
    is.close();
    return cert;
  }

  private static void encrypt() throws IOException, GeneralSecurityException, CMSException {
    CMSEnvelopedDataStreamGenerator gen = new CMSEnvelopedDataStreamGenerator();
    gen.addKeyTransRecipient(certificate());

    InputStream is = new FileInputStream(new File(DIR, "secret"));
    OutputStream out = new FileOutputStream(new File(DIR, "secret.encrypted"));
    OutputStream encryptingOut = gen.open(out, CMSEnvelopedGenerator.AES128_CBC, "BC");

    IOUtils.copy(is, encryptingOut);

    is.close();
    encryptingOut.close();
    out.close();
  }

  public static void main(String[] args) throws Exception {
    Security.addProvider(new BouncyCastleProvider());

    encrypt();
  }
}