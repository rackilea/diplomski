for(int i = 1; i <= pNames.length; i++) {

    System.out.print("Enter name of Player" + " " + i + " > ");

    // The index of pNames must start from 0!
    pNames[i-1] = sc.nextLine();
}