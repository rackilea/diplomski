public boolean equals(Object object) {
    final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
    return equals(null, null, object, strategy);
}

public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
    if (!(object instanceof PurchaseOrderType)) {
        return false;
    }
    if (this == object) {
        return true;
    }
    final PurchaseOrderType that = ((PurchaseOrderType) object);
    {
        USAddress lhsShipTo;
        lhsShipTo = this.getShipTo();
        USAddress rhsShipTo;
        rhsShipTo = that.getShipTo();
        if (!strategy.equals(LocatorUtils.property(thisLocator, "shipTo", lhsShipTo), LocatorUtils.property(thatLocator, "shipTo", rhsShipTo), lhsShipTo, rhsShipTo)) {
            return false;
        }
    }
    {
        USAddress lhsBillTo;
        lhsBillTo = this.getBillTo();
        USAddress rhsBillTo;
        rhsBillTo = that.getBillTo();
        if (!strategy.equals(LocatorUtils.property(thisLocator, "billTo", lhsBillTo), LocatorUtils.property(thatLocator, "billTo", rhsBillTo), lhsBillTo, rhsBillTo)) {
            return false;
        }
    }
    // ...
    return true;
}