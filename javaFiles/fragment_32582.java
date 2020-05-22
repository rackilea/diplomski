public static void main(String[] args) {
    Scanner myScan = new Scanner(System.in);
    while(true) {
        System.out.println("Enter your name");
        String myName = myScan.next();
        System.out.println("Enter your location");
        String myLocation = myScan.next();

        if(myName.equals("X") || myLocation.equals("X")){
            break;
        }

        System.out.println("Your name is " + myName + " and your location is " + myLocation);
    }
}