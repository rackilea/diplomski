static class Response {
    ... skip ..
    private List<Itm> listItm = new ArrayList<Itm>();
    ... skip ..
    @JsonProperty("Itm")
    public void setItm(Itm Itm) {
        this.Itm = Itm;
        listItm.add(Itm);
    }
}