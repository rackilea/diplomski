@ManyToOne(fetch = FetchType.LAZY)
@JoinColumns(value = {
    @JoinColumn(
        name = "ID_CUSTOMER", 
        referencedColumnName = "ID_CUSTOMER"
    ),
    @JoinColumn(
        name = "BRAND", 
        referencedColumnName = "BRAND", 
        insertable = false, 
        updatable = false
    )
})
private CustomerEntity customer;