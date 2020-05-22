public class Fonction {

    private String nom;

    private Integer period;

    ..... All your parameters with getters and setters

    /**
     * @return the nom
     */
    public final String getNom() {
        return nom;
    }

    /**
     * @param pNom the nom to set
     */
    public final void setNom(String pNom) {
        nom = pNom;
    }

    /**
     * @return the period
     */
    public final Integer getPeriod() {
        return period;
    }

    /**
     * @param pPeriod the period to set
     */
    public final void setPeriod(Integer pPeriod) {
        period = pPeriod;
    }    
}