public enum OrderDataType {
    Order1(Order1.class);

    private Class<? extends OrderData> clazz;

    private OrderDataType(Clazz<? extends OrderData> clazz) {
        this.clazz = clazz;
    }

    public Class<? extends OrderData> getClazz() {
        return clazz;
    }
}