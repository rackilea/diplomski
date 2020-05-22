BufferedWriter bout = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
BufferedReader bin = new BufferedReader(new InputStreamWriter(client.getInputStream()));
// Wait for incoming name from client.
String name = bin.readline();
System.out.println(name);
// Send a reply.
bout.write("Thank you\n");
bout.flush();