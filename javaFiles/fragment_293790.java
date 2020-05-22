public void findEntry(){
    Scanner input = new Scanner(System.in);

    System.out.println("Which title do you want to search for?");
    String searchedEntry = input.nextLine();
    System.out.println();
    for(Entry entry : entries){
        if(entry.getTitle().contains(input))
            entry.showDetails();   // or Whatever
    }
}