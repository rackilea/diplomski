ServerSocket serverSock = new ServerSocket(6789);
Socket sock = serverSock.accept();

InputStream sis = sock.getInputStream();
BufferedReader br = new BufferedReader(new InputStreamReader(sis));
String request = br.readLine(); // Now you get GET index.html HTTP/1.1`
String[] requestParam = request.split(" ");
String path = requestParam[1];

PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
File file = new File(path);
if (!file.exists()) {
     out.write("HTTP 404"); // the file does not exists
}
FileReader fr = new FileReader(file);
BufferedReader bfr = new BufferedReader(fr);
String line;
while ((line = bfr.readLine()) != null) {
    out.write(line);
}

bfr.close();
br.close();
out.close();