else
{
    int len = line.length();

    reversedString=""; //this line erases the previous content of the reversed string

    for (int i=len-1; i>=0; i--) { //always use brackets!!!
        reversedstring = reversedstring + line.charAt(i);
    }
    ps.println(""+reversedstring);
}