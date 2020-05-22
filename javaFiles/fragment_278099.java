String urlString = "https://www.grubhub.com/browse/";
URL url = new URL(urlString);
SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
SSLSocket socket = (SSLSocket) factory.createSocket(url.getHost(), 443);
socket.setEnabledProtocols(new String[]{"SSLv3"}); // <--- THIS IS THE WORK-AROUND
PrintWriter out = new PrintWriter(
        new OutputStreamWriter(
                socket.getOutputStream()));
out.println("GET " + urlString + " HTTP/1.1");
out.println();
out.flush();

BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

String line;
while ((line = in.readLine()) != null) {
    System.out.println(line);
}

out.close();
in.close();