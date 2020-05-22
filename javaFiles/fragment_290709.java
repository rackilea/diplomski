public class Oracle10gDialectExtended extends Oracle10gDialect {
    public Oracle10gDialectExtended() {
        super();
        registerKeyword("within"); //Keyword has to be in lowercase.
    }
}