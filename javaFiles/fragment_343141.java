System.out.println("Server Thread " + ID + " running.");
    while (true) {
        try {
            Object message = streamIn.readObject();
            if (message instanceof Message) {
                System.out.println((Message) message);
                server.handleMessage(ID, (Message) message);
            }
        } catch (IOException ex) {
            System.out.println("Listening error: " + ex.getMessage());
            server.remove(ID);
        } catch (ClassNotFoundException ex) {
            System.out.println("Class was not found");
        }

    }