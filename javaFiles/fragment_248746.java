@ManyToOne
@JoinColumns( {
    @JoinColumn(name="vendorCode", referencedColumnName="vendorCode"),
    @JoinColumn(name="vendorBranchCode", referencedColumnName="vendorBranchCode")
} )
private VENDORBRANCH vendorbranch_vendorcode