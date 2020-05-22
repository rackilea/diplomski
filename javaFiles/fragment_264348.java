public class sometest {
     public static void main (String[] args) throws Exception {
         URLConnection c = new URL("https://wstest.agenziadoganemonopoli.gov.it/").openConnection();
         ((HttpsURLConnection)c).connect();
     }
 }
 // for TLS-level test it doesn't matter what 'resource' (path and/or query) we request