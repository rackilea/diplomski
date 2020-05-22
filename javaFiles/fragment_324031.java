Database db = DatabaseBuilder.open(new File("C:/Users/Public/mdbTest.mdb")); 

Table tbl = db.getSystemTable("MSysObjects");
Cursor crsr = tbl.getDefaultCursor();

Map<String, Object> findCriteria = new HashMap<String, Object>();
findCriteria.put("Name", "refNum");
findCriteria.put("Type", (short)1);

String status = "";
if (crsr.findFirstRow(findCriteria)) {
    tbl.deleteRow(crsr.getCurrentRow());
    status = "table dropped (row deleted from MSysObjects)";
}
else {
    status = "row not found in MSysObjects";
}
System.out.println(status);

db.close();