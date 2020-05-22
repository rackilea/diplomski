public static void main (String[] args) {
    Fishdata fishdata = new Fishdata();
    int choice = menu();
    switch (choice) {
    case 1:
        System.out.println(fishdata.getAllFish()); // or whatever you want to do with the list
        break;
    case 2:
        // etc.
    default:
        break;
    }
}