// Send name to server.
bout.write("Name\n");
bout.flush();
// Get a response from the server and print to console.
String response = bin.readline();
System.out.println(response);