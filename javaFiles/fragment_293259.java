Scanner input = new Scanner(System.in);

    System.out.println("Please enter a sentence");

    String sentence = input.nextLine();

    sentence = sentence.toLowerCase();

    System.out.println("You entered : \n" + sentence);
//Doesn't seem to make it to this loop because it only prints the initial sentence
// for (int i=0; i<sentence.length(); i++)
// {

    sentence = sentence.replace('a', '*');
    sentence = sentence.replace('e', '*');
    sentence = sentence.replace('i', '*');

//  }
    System.out.println("This is your new sentence: \n" + sentence);