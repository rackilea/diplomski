public static int word(){
    String words[]= {"Cat","dog"};

    int i = words.length;

    Random rng = new Random();
    int choice = rng.nextInt(words.length); //Varible storing random word
    return choice;

}