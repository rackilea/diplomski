private static boolean isValidStat(int userStat) {
    return userStat >= 10 && userStat <= 16 && userStat != 15;
}

private static int readStat(Scanner scan, String stat, Set<Integer> seenStats) {
    System.out.println("Enter your desired "+stat+" stat: ");
    while(true) {
        int userStat = scan.nextInt();
        if(!isValidStat(userStat))
            System.out.println("Not a valid choice - please try again:");
        else if(seenStats.contains(userStat))
            System.out.println("Already used that number - please try again:");
        else {
            seenStats.add(userStat);
            return userStat;
        }
    }
}

private static int getMod(int userStat) {
    switch(userStat) {
    case 16: return 3;
    case 14: return 2;
    case 13: return 1;
    case 12: return 1;
    case 11: return 0;
    case 10: return 0;
    default: throw new RuntimeException("invalid userStat "+userStat); // shouldn't happen
    }
}

public static void standardArray(Scanner scan) {

    System.out.println("----------------------------------------------------------");
    System.out.println("Assign the numbers \"16\", \"14\", \"13\", \"12\", \"11\", and \"10\" to your skills.");
    Set<Integer> seenStats = new HashSet<Integer>();
    int userStr = readStat(scan, "Str", seenStats);
    int userCon = readStat(scan, "Con", seenStats);
    int userDex = readStat(scan, "Dex", seenStats);
    int userInt = readStat(scan, "Int", seenStats);
    int userWis = readStat(scan, "Wis", seenStats);
    int userCha = readStat(scan, "Cha", seenStats);

    int strMod = getMod(userStr);
    int conMod = getMod(userCon);
    int dexMod = getMod(userDex);
    int intMod = getMod(userInt);
    int wisMod = getMod(userWis);
    int chaMod = getMod(userCha);

    /* do something with all these numbers, of course */
}