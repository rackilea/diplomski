@XmlAnyElement
 @XmlElementRefs({
    @XmlElementRef(type=CreditCardDetails.class),
    @XmlElementRef(type=Wallet.class)   
 })
 PaymentType paymentType;