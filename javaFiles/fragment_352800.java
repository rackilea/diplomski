void addbooktype(String type) {
    System.out.println("You chose: " + type);
    System.out.println("Adding to the list...");        

    // The line below will give error unless you change Books[] booklist;
    // to  String[] booklist;
    booklist[bookcounter++] = kind; 
}