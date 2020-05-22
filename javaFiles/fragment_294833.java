public class Main
{
    public static void main(String args[])
    {
        HeroCreation creation = new HeroCreation();

        Hero hero1 = new Hero();
        hero1.setStrength(creation.askStrength());
        hero1.setIntelligence(creation.askIntelligence());

        Hero hero2 = new Hero();
        hero2.setStrength(creation.askStrength());
        hero2.setIntelligence(creation.askIntelligence());

    }
}