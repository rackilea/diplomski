char first;
try {
    first = scan.nextLine().charAt(0);
} catch(StringIndexOutOfBoundsException siobe){
    System.out.println("invalid input");
}