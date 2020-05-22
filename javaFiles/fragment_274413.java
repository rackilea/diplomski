public BufferedReader in;
public String getServerResponse() throws Exception{
  while(true){
      in = new BufferedReader(new InputStreamReader(socket.getInputStream(), Charset.forName("UTF-8")));
      // the rest of the code
   }
}