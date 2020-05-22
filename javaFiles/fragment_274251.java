ICiPersonalData wh = (ICiPersonalData)ses.getComponent("CI_PERSONAL_DATA");
if (wh == null) throw new UpdateException("Failed to get component");
wh.setInteractiveMode(true);
wh.setGetHistoryItems(true);
wh.setEditHistoryItems(true);
wh.setKeypropEmplid(emplid);
if (!existsInHR(emplid)) { // Direct database check
        LOG.debug("Creating a new HR person.");
    if ( ! wh.create() )
        LOG.warn("wh.create returned false for emplid ="+emplid);
    ses.checkMessages(); // will throw exception if errors exist

    wh.setPropDerivedEmp("Y");
    rs.put("NEW","Y");
    setKeyPersonalData(wh, emplid, rs); // Sets name, etc.

} else {
    if (!wh.get())
        LOG.warn("wh.get returned false for emplid ="+emplid);
    ses.checkMessages();
}