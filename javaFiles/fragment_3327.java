public enum Strategy{
    STRAT1("Strat1", new Mort1()),
    STRAT2("Strat2", new Mort2()),
    DEFAULT("default", new MortSubite());

    private final String name;
    private final Mort mort;

    public String getName(){ return name;}
    public void death(){mort.mort();} //<- void does not really make sense here.

    Strategy( String pName, Mort pMort ){name = pName; mort = pMort;}
}