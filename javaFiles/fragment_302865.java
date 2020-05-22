Scanner sc = new Scanner(System.in);
boolean isChoiceValid = false;
do {
     System.out.println("Are you a Producer or a Consumer?\\\\n (P = Producer, C = Consumer");
    char type = sc.nextLine().toUpperCase().charAt(0);
    if (type == 'P' || type =='C') {
        boolean isChoiceValid = true;
    } else {
        System.out.println("Sorry try Again");
        isValidChoice = false;  // if you want
        continue;
    }
    if (sc.hasNextLine()) {
        String name = sc.nextLine().toUpperCase();
        System.out.println(name);
    }
} while(!isChoiceValid);
System.out.println("You're Done!");