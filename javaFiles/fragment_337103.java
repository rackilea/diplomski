public static boolean isInt(String Input)
{
    try{Integer.parseInt(Input);return true;}
    catch(NumberFormatException e){return false;}
}
public static String reverseNumbersInString(String Input)
{
    char[] Separated = Input.toCharArray();int i = 0;
    String Result = "",Hold = "";
    for(;i<Separated.length;i++ )
    {
        if(isInt(Separated[i]+"") == true)
        {
            while(i < Separated.length && (isInt(Separated[i]+"") == true ||  Separated[i] == '.' ||  Separated[i] == '-'))
            {
                Hold += Separated[i];
                i++;
            }
            Result+=reverse(Hold);
            Hold="";
        }
        else{Result+=Separated[i];}
    }
    return Result;
}