for(int i = 0; i < 5; i++)
{
    if(m[i].startsWith(wordPart) && m[i].endsWith(wordPart)); <<<--- Error!
    {
        System.out.println("both");
    }
    else if(m[i].startsWith(wordPart))
    {
        System.out.println("prefix");
    }
    else
        System.out.println("suffix ");
}