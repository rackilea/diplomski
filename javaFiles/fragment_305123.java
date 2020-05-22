class Unit
{
    private String s1;
    private Sword s;

    public Unit(String s1)
    {
        this.s1 = s1;
        this.s = new Sword();
    }

    private class Sword
    {
        private int a;
    }
}