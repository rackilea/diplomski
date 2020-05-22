} else if (clientMessage.equals("message_broadcast")) {
                String message = inputStream.readLine();
                for (ClientThread clientThread : Server.clientsList) {
                    if (clientThread != this) {
                        clientThread.outputStream.println(clientName + ": " + message);
                        clientThread.outputStream.flush();
                    }
                }