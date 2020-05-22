public void listenSocket(int portNum){
  AccessController.doPrivileged(new PrivilegedAction() {
        public Object run() {
            int portNum = 4444;
try{
  System.out.println("@server Trying to create socket bound to port " + portNum);
  server = new ServerSocket(portNum); 
  System.out.println("the attached socket port is " + server.getLocalPort());
} catch (IOException e) {
  System.out.println("Could not listen on port " + portNum);
  System.exit(-1);
}

try{
  client = server.accept();
  System.out.println("Connection accepted!");
} catch (IOException e) {
  System.out.println("Accept failed: " + portNum);
  System.exit(-1);
}

try{
  in = new BufferedReader(new InputStreamReader(client.getInputStream()));
  out = new PrintWriter(client.getOutputStream(), true);
} catch (IOException e) {
  System.out.println("Accept failed: " + portNum);
  System.exit(-1);
}

try {
    line = in.readLine();
    System.out.println("line is " + line + " from the inputstream to the 
            serversocket");
} catch (IOException e1) {
    // TODO Auto-generated catch block
    e1.printStackTrace();
}

if(line != null){
  System.out.println("trying to read from non-null inputstream...");
//line = in.readLine();
System.out.println(line);
//Now that we have a method name, invoke that bitch!
try {
    serverMethod = hNet.getClass().getDeclaredMethod(line, String.class);
} catch (SecurityException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
} catch (NoSuchMethodException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}

try {
    serverMethod.invoke(hNet, "Hello From Javascript invoked by a desktop 
             app!");
} catch (IllegalArgumentException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
} catch (IllegalAccessException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
} catch (InvocationTargetException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}

//Send data back to client
out.println("awesome " + line);
//System.out.println(line);
//System.out.flush();

 }

return null;
        }
    });//end doPrivileged
}