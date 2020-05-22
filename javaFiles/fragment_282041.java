String diceResult = jLabelDiceResult.getText();
String[] parsedResults = diceResult.split(" ");
for (int i=0; i<parsedResults.length; i++)
{
    switch (Integer.parseInt(y[i]))
    {
        case 1: jPanel2.add(x[i]);
            break;
        case 2: jPanel2.add(x[i]);
            break;
    }
}