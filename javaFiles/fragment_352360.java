public int DeleteDigit(int number, int numberToDel)
{
    String Num = "" + number;
    Num = Num.replace(numberToDel + "", "");

    if(Num.length != 0)
        return Integer.parseInt(Num);
    return 0;
}