String returnstring = "";

if(cipher.equals(""))
{
        return "no cipher";
}

if(cipher.length() %6!=0)
{
        return "invalid cipher";
}

if(cipher.length()==6)
{
        char A = decipherChar(cipher.substring(0,6));
        returnstring =  Character.toString(A);
}

if(cipher.length()==12)
{
        char A = decipherChar(cipher.substring(0,6));
        char B = decipherChar(cipher.substring(6,12));
        returnstring =  Character.toString(A) + Character.toString(B) ;
}

if(cipher.length()==18)
{
        char A = decipherChar(cipher.substring(0,6));
        char B = decipherChar(cipher.substring(6,12));
        char C = decipherChar(cipher.substring(12,18));
        returnstring =  Character.toString(A) + Character.toString(B) +
Character.toString(C);
}

if(cipher.length()==24)
{
        char A = decipherChar(cipher.substring(0,6));
        char B = decipherChar(cipher.substring(6,12));
        char C = decipherChar(cipher.substring(12,18));
        char D = decipherChar(cipher.substring(18,24));
        returnstring =  Character.toString(A) + Character.toString(B) +
Character.toString(C) + Character.toString(D);
}
return returnstring;