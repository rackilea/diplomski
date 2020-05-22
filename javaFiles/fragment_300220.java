@ManyToMany( cascade = {CascadeType.ALL})
@JoinTable(name="BILL_PAYMENTS",
    joinColumns=
    @JoinColumn(name="payments_id", referencedColumnName="id"),
    inverseJoinColumns=
    @JoinColumn(name="bills_id", referencedColumnName="id")