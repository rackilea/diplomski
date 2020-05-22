final Dice dice = spy(new Dice());

doNothing().when(dice).clearAllDiceSelections();

dice.rollAllDice();

verify(dice).clearAllDiceSelections();