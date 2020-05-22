public class RomanNumerals
{
    public String convertToRomanNumeral(int number)
    {
        String numberString = "";
        switch ((number%10000)/1000)  
        {
            case 1:  numberString += "M";
                break;
            case 2:  numberString += "MM";
                 break;
            case 3:  numberString += "MMM";
                 break;
        }
        switch ((number%1000)/100) 
        {
            case 1:  numberString += "C";
                 break;
            case 2:  numberString += "CC";
                 break;
            case 3:  numberString += "CCC";
                 break;
            case 4:  numberString += "CD";
                 break;
            case 5:  numberString += "D";
                  break;
            case 6:  numberString += "DC";
                  break;
            case 7:  numberString += "DCC";
                  break;
            case 8:  numberString += "DCCC";
                 break;
            case 9:  numberString += "CM";
                 break;
        }
        switch ((number%100)/10) 
        {
            case 1:  numberString += "X";
                 break;
            case 2:  numberString += "XX";
                 break;
            case 3:  numberString += "XXX";
                 break;
            case 4:  numberString += "XL";
                 break;
            case 5:  numberString += "L";
                 break;
            case 6:  numberString += "LX";
                 break;
            case 7:  numberString += "LXX";
                 break;
            case 8:  numberString += "LXXX";
                 break;
            case 9:  numberString += "XC";
                 break;
        }
        switch (number%10) 
        {
            case 1:  numberString += "I";
                 break;
            case 2:  numberString += "II";
                 break;
            case 3:  numberString += "III";
                 break;
            case 4:  numberString += "IV";
                 break;
            case 5:  numberString += "V";
                 break;
            case 6:  numberString += "VI";
                 break;
            case 7:  numberString += "VII";
                 break;
            case 8:  numberString += "VIII";
                 break;
            case 9:  numberString += "IX";
                 break;
        }
        return numberString;
    }       
}