Scanner sc = new Scanner(System.in);
while (true) {
    System.out.println("Enter file name");
    String filename = sc.next();
    if (!filename.startsWith("sth")) {    //this will reask if the file name doesn't start with "sth"
        continue;
    try {
        Scanner s = sc; //just in case you never gonna use System.in
        sc = new Scanner(new File(filename));
        s.close(); //just in case you're sure you never gonna use System.in
        break;
    } catch (Exception e) {
        System.out.println("Wrong filename - try again");
    }
}