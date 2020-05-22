for(int i = 0 ; i < stars ; i++) {
    System.out.print("*"); // top
}
System.out.println(); // new line
for (int j = 0 ; j < stars - 2 ; j++) {
    System.out.print("*"); // starting * of the middle
    for (int i = 0; i < stars - 2; i++) {
        System.out.print("."); // the dots for the middle
    }
    System.out.print("*"); // the star at the end of the middle lines
    System.out.println(); // new line for the next middle line
}
for(int i = 0 ; i < stars ; i++) {
    System.out.print("*"); // bottom
}