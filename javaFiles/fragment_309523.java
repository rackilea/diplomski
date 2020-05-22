// function for clearing the line by printing escape char '\b'
private static void cls(){
    System.out.print(" ");
    for (int i = 0; i < 50; i++) {
        System.out.print("\b");
    }
} //End of cls