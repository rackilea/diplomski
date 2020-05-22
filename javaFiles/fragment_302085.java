private static Random rand = new Random(); 

public static void main(String[] args) {

    double blockChance = .5; // 50% chance to block the attack

    Double pickedNumber = rand.nextDouble(); // Roll to see if we block the attack

    System.out.println(pickedNumber); // output roll for debug purposes

    if(pickedNumber < blockChance){ // if the attack was blocked
        System.out.println("Blocked"); // do block logic
    }else{ // if the attack wasn't blocked
        System.out.println("Damaged"); // do damage logic
    }
}