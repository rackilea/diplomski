public class TcinDpciMapDTO {
    @JsonProperty("tcin")
    private String tcin;
    @JsonProperty("dpci")
    private String dpci;
    @JsonProperty("is_primary_tcin_in_dpci_relation")
    private boolean is_primaryTcin = true;

    public String getTcin() {
        return this.tcin;
    }

    public String getDpci() {
        return this.dpci;
    }

    public boolean is_primaryTcin() {
        return this.is_primaryTcin;
    }

    public TcinDpciMapDTO setTcin(String tcin) {
        this.tcin = tcin;
        return this;
    }

    public TcinDpciMapDTO setDpci(String dpci) {
        this.dpci = dpci;
        return this;
    }

    public TcinDpciMapDTO set_primaryTcin(boolean is_primaryTcin) {
        this.is_primaryTcin = is_primaryTcin;
        return this;
    }

    public TcinDpciMapDTO() {
    }

    public String toString() {
        return "TcinDpciMapDTO(tcin=" + this.getTcin() + ", dpci=" + this.getDpci() + ", is_primaryTcin=" + this.is_primaryTcin() + ")";
    }
}