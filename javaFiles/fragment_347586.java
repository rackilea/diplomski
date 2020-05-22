String line = null;

while ((line = read.readLine()) != null) 
{
    for (int i = 0; i < line.length(); i++) 
    {
        if (Character.isLetter(line.charAt(i))) 
        {
            System.out.print(line.charAt(i));
        }
    }
}