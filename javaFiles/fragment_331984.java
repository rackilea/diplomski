// After a few changes...
Socket clientSocket = serverSocket.accept();
BufferedReader in = new BufferedReader(new InputStreamReader(
     clientSocket.getInputStream()));
String nextLine;
while ((nextLine = in.readLine()) != null) {
    System.out.println(nextline);
}