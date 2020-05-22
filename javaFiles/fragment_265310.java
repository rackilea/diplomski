static class TestTableData {
    private String id, callsign, categorie;

    @TableColumn(label = "Caterogy", order = 3)
    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    @TableColumn(label = "Call sign", order = 2)
    public String getCallsign() {
        return callsign;
    }

    public void setCallsign(String callsign) {
        this.callsign = callsign;
    }

    @TableColumn(label = "ID", order = 1)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}