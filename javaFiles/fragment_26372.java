public enum OrderStatus {
    private Integer codice;

    public Integer getCodice() {
        return codice;
    }

    private OrderStatus(Integer codice) {
        this.codice = codice;
    }

    OPEN(0),
    DELIVERED(1),
    CANCELLED(3),
    PARTIALLY(4)
}