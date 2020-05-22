String line = read.readLine();

while (line != null) 
{
    for (int i = 0; i < line.length(); i++) 
    {
        if (Character.isLetter(line.charAt(i))) 
        {
            System.out.print(line.charAt(i));
        }
    }
    line = read.readLine();
    //line is never used after this so an NPE is not possible
}