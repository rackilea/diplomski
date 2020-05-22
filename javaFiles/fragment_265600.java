public static void readText(Scanner input, int[]text){
        char letter = 0;

        while (input.hasNext()) {
            String a = input.nextLine();

            for (int i = 0; i < a.length(); i++) {
                letter = a.charAt(i);

                if (letter >= 'A' && letter <= 'Z') {
                    text[letter-65] = (text[letter-65]) + 1;
                }
                else if (letter >= 'a' && letter <= 'z') {
                    text[(letter - 32) - 65] = (text[(letter - 32) - 65]) + 1;
                }
                else if (letter == ' ') {
                    System.out.print("");
                }
                else {
                    System.out.print("");
                }
            }
        }

        String[] alphabet = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

        boolean emptyOutput = true;
        for (int y = 0; y < text.length; y++) {
            if (text[y] > 0) {
                System.out.println(alphabet[y] + ": " + text[y]);
                emptyOutput = false;
            }
        }
        if (emptyOutput) {
            System.out.println();
        }
    }