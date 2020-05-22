System.out.println("Enter the a word to be converted : ");

    String Letter = console.nextLine();
    Letter = Letter.replaceAll("\\s", "");
    Letter = Letter.toUpperCase();
    Letter = Letter.toLowerCase();
    String Number = "";