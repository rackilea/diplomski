CompleteRecord record = null;//move declaration outside of loop
while(rsV.next()){

    PovagrmthdDbo aPovagrmthdDbo = new PovagrmthdDbo();
    PovagrmtlnDbo aPovagrmtlnDbo = new PovagrmtlnDbo();
    aPovagrmthdDbo.setProcure_Group(rsV.getString("PROCURE_GROUP"));
    aPovagrmthdDbo.setVen_Agrmt_Ref(rsV.getString("VEN_AGRMT_REF"));
    aPovagrmthdDbo.setVendor(rsV.getString("VENDOR"));
    aPovagrmthdDbo.setPurch_Fr_Loc(rsV.getString("PURCH_FR_LOC"));
    aPovagrmtlnDbo.setLine_Nbr(rsV.getInt("LINE_NBR"));
    aPovagrmtlnDbo.setItem(rsV.getString("ITEM"));
    aPovagrmtlnDbo.setVen_Item(rsV.getString("VEN_ITEM"));
    aPovagrmthdDbo.setR_Status(rsV.getInt("R_STATUS"));

    record = new 
    CompleteRecord(rsV.getString("PROCURE_GROUP"), 
    rsV.getString("AGREEMENT_REF"),
    rsV.getString("VENDOR"), rsV.getString("PURCH_FR_LOC"), 
    rsV.getInt("LINE_NBR"), rsV.getString("ITEM"),
    rsV.getString("VEN_ITEM"), FC_CODE, rsV.getInt("R_STATUS"), 
    ts.toString());
}
return record;