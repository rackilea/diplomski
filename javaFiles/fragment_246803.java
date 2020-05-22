private String processInput() throws IOException {
        String line;
        StringBuilder buff = new StringBuilder();
        int i;
        byte[] buffer = new byte[2048];
        i = in.read(buffer);
        for (int j = 0; j < i; j++) {
            buff.append((char) buffer[j]);
        }
        System.out.println(buff.toString());
        out.print(STATUS_200);
        out.print("Server: Test Server\n" +
            "Content-Type: text/html; charset=UTF-8\n" +
            "Connection: close");
        out.print(EOF);
        out.print("<html><body>yello</body></html>"); 
        out.print(EOF);
        out.flush();
        System.out.println(STATUS_200);
        return buff.toString();
}