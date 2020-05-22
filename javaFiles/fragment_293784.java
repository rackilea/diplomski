for(int j=0; j<allChar.length(); j++)
{
    if(allChar.charAt(j) == a)                   
    {
        char c= allChar.charAt(j+key);
        String cipher = "null"+c;

        System.out.print("\t"+c );
    }
    System.out.println(cipher);
    // cipher is not defined / initialzed here.
    // this is not the "end" of the loop but within its body,
    // thus prints on every iteration
}