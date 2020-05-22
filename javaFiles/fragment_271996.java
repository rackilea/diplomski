for(int i =1; i<word.length()-1; i++) // -1 so the last letter is not added
{
    output += word.charAt(i);
    for(int j =i+1; j<word.length()-i; j++)
    {
        output += " ";
    }
    output += word.charAt((word.length()-i-1)) + "\n";
}