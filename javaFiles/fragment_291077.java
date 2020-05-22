static void printCentered() {
        String[] textArray = new String[5];
        int maxi = -1;
        textArray[0] = "Drei Chinesen mit dem Kontrabass";
        textArray[1] = "sassen auf der Strasse und erzaehlten sich was.";
        textArray[2] = "Da kam ein Mann: Ja was ist denn das?";
        textArray[3] = "Drei Chinesen mit dem Kontrabass.";
        textArray[4] = "Hello World!";
        for (int i = 0; i <= 4; i++)
            if (textArray[i].length() > maxi)
                 maxi = textArray[i].length();
        final int maxiByTwo = maxi / 2;
        for (int i = 0; i <= 4; i++) {
            final int textLenByTwo = textArray[i].length() / 2;
            final int diff = maxiByTwo - textLenByTwo;
            for (int j = 0; j < diff; j++)
                System.out.print(" ");
            System.out.println(textArray[i]);
        }
    }