for(v = 1; v <= 10; ++v)
{
    if(Math.random() <= 0.5)
    {
        System.out.println("Heads");
        ++heads;
    }
    else
    {
        System.out.println("Tails");
        ++tails;
    }
}