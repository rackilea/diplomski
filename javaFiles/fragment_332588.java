if (result != null and result.size() == 1) {
    // Update here
    ODocument doc = result.get(0);
    doc.field("rpstryId", obj.getRpstryId());
    doc.field("objId", obj.getObjId());
    doc.field("objIdCntxtCd", obj.getObjIdCntxtCd());
    doc.field("objTypId", obj.getObjTypId());
    doc.field("objNm", obj.getObjNm());
    doc.field("objDesc", obj.getObjDesc());
    System.out.println("Completed");
    doc.save();                    
    db.close();
} else {
    System.out.println("Couldn't find the record.");
}