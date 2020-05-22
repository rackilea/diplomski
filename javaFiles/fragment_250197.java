BufferedReader reader = ...

String receivedMessage = reader.readLine();
assertEquals("Hello, world!", receivedMessage);
mockTestClientSocket.close();
connection.closeSocket();