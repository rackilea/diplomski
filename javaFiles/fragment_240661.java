private List<Dobbelsteen> dice;

public TekenPaneel() {

    TextDialog dialog = new TextDialog();
    int numberOfDice;
    if (dialog.isDialogCompleted()) {
        numberOfDice = Integer.parseInt(dialog.getInput());
    }
    else {
        // use a default if the user cancels the input
        numberOfDice = 2;
    }
    dice = new ArrayList<Dobbelsteen>();
    int x = 1;
    for(int i = 1; i < numberOfDice; i++) {   
        dice.add(new Dobbelsteen(x));
        x = x + 2;
    }