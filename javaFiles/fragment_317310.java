Socket echoSocket =null
    PrintWriter out =null
    BufferedReader in =null
    BufferedReader stdIn =null
  try{


   echoSocket = new Socket(hostName, portNumber);
    out =
        new PrintWriter(echoSocket.getOutputStream(), true);
    in =
        new BufferedReader(
            new InputStreamReader(echoSocket.getInputStream()));
    stdIn =
        new BufferedReader(
            new InputStreamReader(System.in));

    String userInput;
    while ((userInput = stdIn.readLine()) != null) {
        out.println(userInput);
        System.out.println("echo: " + in.readLine());
    }
  }finally{
   if(stdIn !=null){
      try{
        stdIn.close()
      }catch(Exception e){
      //surpress exception if needed
     }
   }
  if(in !=null){
     try{
        in.close()
      }catch(Exception e){
      //surpress exception
     }
   }
   if(out !=null){
     try{
        out.close()
      }catch(Exception e){
       //surpress exception
     }
   }
   if(echoSocket !=null){
     try{
        echoSocket.close()
      }catch(Exception e){
        //surpress exception
     }
  }
}