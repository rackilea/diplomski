BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));    

String fromUser;
while((fromUser = stdIn.readLine()) != null) {
    System.out.println("Client: " + fromUser);
    toServer.println(fromUser);
}