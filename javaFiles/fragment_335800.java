public enum RegimeTributario {
    SIMPLES_NACIONAL("SI"), 
    LUCRO_PRESUMIDO("LP"), 
    LUCRO_REAL("LR");

    private String sigla;

    private RegimeTributario(String sigla) {
        this.sigla = sigla;
    }

    public String getSigla() {
        return sigla;
    }
}