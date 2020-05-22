public String roundNumber(double number)
{    
    int integer = Integer.parseInt(String.valueOf(number).split("\\.")[0]);
    String decimal = String.valueOf(number).split("\\.")[1];
    int decimalAsNumber = 0;

    if(!decimal.startsWith("0"))
        if(Integer.parseInt(decimal) < 10)
            decimalAsNumber = Integer.parseInt(decimal) * 10;
    else
        decimalAsNumber = Integer.parseInt(decimal);

    while(decimalAsNumber % 5 > 0)
        decimalAsNumber++;

    decimal = String.valueOf(decimalAsNumber);

    if(decimal.length() == 1)
        decimal += "0";

    return String.valueOf(integer) + "." + decimal;
}