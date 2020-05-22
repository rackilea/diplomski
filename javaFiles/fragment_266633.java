try {
   Socket socket = new Socket( host, port );
   BufferedReader in = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );
   PrintWriter out = new PrintWriter( new OutputStreamWriter( socket.getOutputStream() ) );

   out.println("HELO");
   String response = in.readLine();
   System.out.println( response );
} finally {
   in.close();
   out.close();

   socket.close();
}