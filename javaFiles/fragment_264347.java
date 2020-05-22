public class sometest {
     public static void main (String[] args) throws Exception {
          Socket s = SSLSocketFactory.getDefault().createSocket("wstest.agenziadoganemonopoli.gov.it",443);
          // per comment, type fixed (for anyone else who might have a similar issue)
          ((SSLSocket)s).startHandshake(); // actually completes not just starts
     }
 }