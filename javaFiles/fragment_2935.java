// Arg[0] = Hostname
// Arg[1] = File like index.html
public static void main(String[] args) throws Exception {
    SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();

    SSLSocket sslsock = (SSLSocket) factory.createSocket(args[0], 443);

    SSLSession session = sslsock.getSession();
    X509Certificate cert;
    try {
        cert = (X509Certificate) session.getPeerCertificates()[0];
    } catch (SSLPeerUnverifiedException e) {
        System.err.println(session.getPeerHost() + " did not present a valid cert.");
        return;
    }

    // Now use the secure socket just like a regular socket to read pages.
    PrintWriter out = new PrintWriter(sslsock.getOutputStream());
    out.write("GET " + args[1] + " HTTP/1.0\r\n\r\n");
    out.flush();

    BufferedReader in = new BufferedReader(new InputStreamReader(sslsock.getInputStream()));
    String line;
    String regExp = ".*<a href=\"(.*)\">.*";
    Pattern p = Pattern.compile( regExp, Pattern.CASE_INSENSITIVE );

    while ((line = in.readLine()) != null) {
        // Using Oscar's RegEx.
        Matcher m = p.matcher( line );  
        if( m.matches() ) {
            System.out.println( m.group(1) );
        }
    }

    sslsock.close();
}