public static String convertColumn(String textF)
{


    String textAux = "";
    String newText = "[";

    int i = 0;

    textF = textF.substring(1, textF.length() - 1);

    while(i < textF.length())
    {
        textAux = textF.substring(i, i + 5);
        int nrAux = Integer.parseInt(textAux);

        i+=7;
        int a;
        int b;

        a = nrAux / 1000;
        b = nrAux - a * 1000;

        double newNr;
        newNr = a + b * 0.001;
        newText = newText + newNr + ", ";

    }
    newText = newText.substring(0, newText.length() - 2);
    newText += "]";
    return newText;
}