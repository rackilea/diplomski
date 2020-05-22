int aNumber = 0;
int numThrown = 0;
Dice dice = new Dice();
while(numThrown < 3)
{
    aNumber = iBox.getInteger("Enter 1 to throw the dice, or 0 to exit: ");
    if(aNumber == 1)
    {
        dice.throwDice();
        int rollledNum = dice.getFaceValue();
        oBox.println( "You threw : " + dice.getFaceValue() );
    } 
    else
    {
        return;
    }

    numThrown++;
}