// count < 20 instead of count <= 20
for (int count = 0; count < 20; count++) {

    int rollValue = diceNumber.nextInt(6) + 1;
    System.out.println(rollValue);
}