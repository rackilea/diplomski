private enum Names
{
    fourniture(0),
    nourriture(1),
    voyages(2),
    habillement(3),
    medias(4),
    autres(5);

    private int val;

    Names(int a)
    {
        val = a;
    }

    public int get()
    {
        return val;
    }
};