// Loop start from 0 and goes to 4 excluded
for (int i = 0; i < pNames.length; i++) {

    // To print Enter name of Player 1 change i to (i + 1)
    System.out.print("Enter name of Player" + " " + (i + 1) + " > ");

    pNames[i] = sc.nextLine();
}