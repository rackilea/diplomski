@ManyToOne
@JoinColumnsOrFormulas({
    @JoinColumnOrFormula(formula=@JoinFormula(value="(SELECT b.id FROM Basket b WHERE b.pid = pid)", referencedColumnName="id")),
    @JoinColumnOrFormula(column = @JoinColumn(name = "pid", referencedColumnName="pid"))
})
private Basket getBasket() {
    return this.basket;
}