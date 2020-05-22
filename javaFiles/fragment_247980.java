public static int getSafeInteger(){
    Scanner scan=new Scanner(System.in); //if using scanner over and over consider passing the scanner as an argument
    while(scan.hasNextInt()==false){
        scan.next();
        System.out.println("Only integers are valid");
    }
    return scan.nextInt();
}