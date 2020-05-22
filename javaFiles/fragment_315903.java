public enum Valoracion {
    NO_VALUED (0) {
        @Override int getValor() {
            throw new ValorationNoValued("message");
        }
    },
    SO_BAD (0),
    BAD(2),
    OK (4),
    GOOD (6),
    EXCELENT (8),
    WOW (10);

....
int getValor() {
    return valorValue;
}
public boolean isBigger(Valoration val) throws ValorationNoValued {
    return val.getValor()>this.getValor();
}