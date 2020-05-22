public class Language  implements java.io.Serializable {
    private Integer idlanguage;
    private String language;

    protected Language() {
    }


    public Language(String language) {
        this.language = language;
    }

    public Integer getIdlanguage() {
        return this.idlanguage;
    }

    protected void setIdlanguage(Integer idlanguage) {
        this.idlanguage = idlanguage;
    }
    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}