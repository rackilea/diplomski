while ((c = br.read()) != -1)
{
    char character = (char) c;
    if (Character.isLetter(character))
    {
        if (Character.isUpperCase(character))
        {
            character = Character.toLowerCase(character);
            System.out.print(character);
        }
    }
}