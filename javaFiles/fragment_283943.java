public LinkedList(String[] data){
    this(); //Call the default constructor to set up default properties
    for (String d : data){
        add(d); //Call on this
    }
}