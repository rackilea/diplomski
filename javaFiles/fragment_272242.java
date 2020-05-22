for (int i = 0; i < sgsnPDPRecord.size(); i++) {
    DERTaggedObject obj = (DERTaggedObject) sgsnPDPRecord.getObjectAt(i);
    // get the value with obj.getObject()
    switch (obj.getTagNo()) {
        case 0: // CallEventRecordType
            break;
        case 1: // NetworkInitiatedPDPContext
            break;
        case 3: // IMSI
            break;
        case 4: // IMEI
            break;
        default:
            break;
    }
}