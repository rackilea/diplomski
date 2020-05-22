public static void main(String[] args) throws IOException {
        char answer = 'K', ignore, ch = 'a';
        int i = 0;
        System.out.println("I am Thinking of a letter between A and Z, can  you guess it?");
        while (ch != 'K') {
            ch = (char) System.in.read();
            if(!Character.isLetter(ch)){
                continue;
            }
            System.out.println("Wrong ! please try again");
            i++;
        }

        System.out.println("Correct!, you guessed after " + i + " attempts");

    }