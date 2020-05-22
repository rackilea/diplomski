import sun.security.util.ObjectIdentifier;
import sun.security.x509.X509CertImpl;
import java.util.regex.Matcher;  
import java.util.regex.Pattern;

class readCert{

    public boolean isExtAuthorityInfoAccess(Extension ext){
        Pattern re = Pattern.compile("\\bcaIssuers\\b",Pattern.CASE_INSENSITIVE);
        Matcher m = re.matcher(ext.toString());
        if (m.find()) {
            return true;
        } else {
            return false;
        }
    };

    public static List<String> getAuthorityInfoAccesssUrls(String text)
    {
        List<String> containedUrls = new ArrayList<String>();
        Pattern pattern = Pattern.compile(
                "(?:^|[\\W])((ht|f)tp(s?):\\/\\/|www\\.)"
                        + "(([\\w\\-]+\\.){1,}?([\\w\\-.~]+\\/?)*"
                        + "[\\p{Alnum}.,%_=?&#\\-+()\\[\\]\\*$~@!:/{};']*)",
                Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
        Matcher urlMatcher = pattern.matcher(text);
        while (urlMatcher.find())
        {
            containedUrls.add(text.substring(urlMatcher.start(0),
                    urlMatcher.end(0)));
        }
        return containedUrls;
    };

    public static void main(String[] args) {

        readCert rc = new readCert();

        try {
            File file = new File("yourcert.crt");
            byte[] encCert = new byte[(int) file.length()];
            FileInputStream fis = new FileInputStream(file);
            fis.read(encCert);
            fis.close();

            InputStream in = new ByteArrayInputStream(encCert);
            CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
            X509Certificate cert = (X509Certificate)certFactory.generateCertificate(in);

            X509CertImpl impl = (X509CertImpl)cert;
            int extnum = 0;
            if (cert.getNonCriticalExtensionOIDs() != null) {
                for (String extOID : cert.getNonCriticalExtensionOIDs()) {
                    Extension ext = impl.getExtension(new ObjectIdentifier(extOID));
                    if (ext != null) {
                        if (rc.isExtAuthorityInfoAccess(ext)) {
                            System.out.println(rc.getAuthorityInfoAccesssUrls(ext.toString()));
                            // System.out.println("#"+(++extnum)+": "+ ext.toString());
                            // CA ISSUERS ARE HERE
                        }
                    }
                }
            }
        } catch (  Exception e) {
            e.printStackTrace();
          };
    }
}