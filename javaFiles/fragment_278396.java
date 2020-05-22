interface IdSize {
    Integer getId();
    BigDecimal getSize();
}

class Entity implements IdSize {

    private Integer id;
    private BigDecimal size;
    @Override
    public Integer getId() {
        return id;
    }
    @Override
    public BigDecimal getSize() {
        return size;
    }

}