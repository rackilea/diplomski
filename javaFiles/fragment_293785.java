cipher  = ""; // initalize cipher
for(int j = 0; j < allChar.length(); j++)
{
    if(allChar.charAt(j) == a)                   
    {
        char c= allChar.charAt(j + key);
        cipher += "null"+c; // don't know the logic here!

        System.out.print("\t" + c);
    }
}
System.out.println(cipher); // print result after loop