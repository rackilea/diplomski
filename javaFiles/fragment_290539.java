private void compareAndPopulateArrays(List<String> xmlGenIds,
        List<String> dbGenIds, String dbUrl)
        throws ClassNotFoundException, SQLException {
    //Better yet move it into an init method or the class constructor
    mdbAccessor = new MDBAccessor(dbUrl);
    for (String currXmlId : xmlGenIds) {
        Boolean matchingIdFound = false;
        for (String currDbId : dbGenIds) {
            if (currXmlId.equals(currDbId) || 
                    equalsLanguageCodeIgnore(currXmlId,currDbId)) {
                addNewMatchingRecognition(currDbId, currXmlId);
                matchingIdFound = true;
            }
        }
        if (!matchingIdFound) {
            newRecognitions.add(new NewRecognition(currDbId));
        }
    }
}