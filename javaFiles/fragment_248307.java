final Socket socket = new Socket((String) null, 50000);

            final BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            final PrintWriter writer = new PrintWriter(
                    socket.getOutputStream(), true);
            writer.println("ala bala\r\n");

            System.out.println(reader.readLine());            
            //writer.flush();
            writer.close();