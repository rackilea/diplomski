try {
            Scanner reader = new Scanner(System.in);
            String userInput;//Check if there is input from the user
            do {
                input = iStream.readUTF();
                System.out.println(input);
                userInput = reader.next();
                oStream.writeUTF(userInput);
            } while (input != null);
            reader.close();
        }