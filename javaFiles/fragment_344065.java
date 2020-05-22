try {
            Scanner reader = new Scanner(System.in);
            input = iStream.readUTF();
            String userInput;//Check if there is input from the user
            while (input != null) {
                input = iStream.readUTF();
                System.out.println(input);
                userInput = reader.next();
                oStream.writeUTF(userInput);
}