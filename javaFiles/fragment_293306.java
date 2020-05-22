public class DkSystemtherapieMerkmaleEntity {
    private Integer eintragId;
    private String feldname;
    private String feldwert;

    public DkSystemtherapieMerkmaleEntity(Integer eintragId, String feldname, String feldwert) {
        this.eintragId = eintragId;
        this.feldname = feldname;
        this.feldwert = feldwert;
    }

    public Integer getEintragId() {
        return eintragId;
    }

    public void setEintragId(Integer eintragId) {
        this.eintragId = eintragId;
    }

    public String getFeldname() {
        return feldname;
    }

    public void setFeldname(String feldname) {
        this.feldname = feldname;
    }

    public String getFeldwert() {
        return feldwert;
    }

    public void setFeldwert(String feldwert) {
        this.feldwert = feldwert;
    }
}