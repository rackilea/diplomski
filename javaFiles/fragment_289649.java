@OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "cus_invoice_adr_id", nullable = true)
@Cascade(value = CascadeType.ALL)
@InvoiceAddressChecker
public Addresses getInvoiceAddress() {
    return invoiceAddress;
}