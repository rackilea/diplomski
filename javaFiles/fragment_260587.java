for (int i = 0; i < numDice; i++)
{
    rollValue = roll.nextInt(6) + 1;
    System.out.println("Roll is: " + rollValue);

}
totalRoll = statBonus + rollValue;