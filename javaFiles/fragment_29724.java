while (s.hasNextLine())
{
    String line=s.nextLine();
    if(line.contains(str))
    {
        return true;
    }
}   
return false;