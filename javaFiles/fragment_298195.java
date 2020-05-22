while (true) {
     try {
     // Wait here and listen for a connection
     Socket s1 = s.accept();

     // Get output stream associated with the socket
     OutputStream s1out = s1.getOutputStream();
     BufferedWriter bw = new BufferedWriter(
     new OutputStreamWriter(s1out));

     // Send your string!
     bw.write(“Hello Net World!\n”)

     // ...