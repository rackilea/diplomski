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

while(portNum==4444){
  try{
     System.out.println("trying to read from inputstream...");
    line = in.readLine();
    System.out.println(line);
    //Now that we have a method name, invoke it
    try {
        serverMethod = hNet.getClass().getDeclaredMethod(line, 
     String.class);
    } catch (SecurityException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (NoSuchMethodException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    try {
        serverMethod.invoke(hNet, "Hello from Javascript invoked by the
    desktop app!");
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

  } catch (IOException e) {
    System.out.println("Read failed");
    System.out.flush();
    System.exit(-1);
  }

}

return null;
        }
    });//end doPrivileged
}