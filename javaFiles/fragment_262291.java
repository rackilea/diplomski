DataOutputStream dataout = null;

try {
            System.out.println("Waiting for clients to connect...");
            Socket s = ss.accept(); 
            dataout = new DataOutputStream(s.getOutputStream());
            System.out.println("Client connected!");

            }
            catch(IOException e){
                System.out.println("Error");
            }