if (gender.equals(exit)) {
    System.out.println("\t\t *** Thank you for using this Application ***");
    System.exit(0);
}
else if (! (gender.equals(man) || gender.equals(woman)) ) {
    System.out.println("\t Wrong Selection of gender!");
    System.exit(0); 
}