String sentence= "this is a message";   
String modifiedSentence;   

//client opens a socket
Socket clientSocket = new Socket("localhost", 6789);   

DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());   
BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));   

//writes to the server
outToServer.writeBytes(sentence + '\n');   
modifiedSentence = inFromServer.readLine();   

System.out.println("FROM SERVER: " + modifiedSentence);   

//communication is finished, close the connection
clientSocket.close();