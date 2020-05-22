Scanner input = new Scanner(System.in);
    String b = input.nextLine();
    String Books[] = { "Harry Potter", "To Kill a Mocking Bird", "Hunger Games" };

    for (int t = 0; t < Books.length; t++) {   
        if(b.equals(Books[t])){
            System.out.println("Getting from switch case " + t+1 + " " + Books[t]);
        }
    }