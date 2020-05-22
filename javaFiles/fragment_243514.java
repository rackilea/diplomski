private class DatabaseInterface {
    private PreparedStatement insertAnnotation, getProteinId;
    public DatabaseInterface() {
        // This is an inner class; 'connection' is variable in outer class
        insertAnnotation = connection.prepareStatement(
            "INSERT INTO Annotations(GOId, ProteinId, OnthologyId) VALUES(?, ?, ?)");
        getProteinId = connection.prepareStatement(
            "SELECT Id FROM Proteins WHERE PrimaryUniProtKBAccessionNumber = ?");
    }
    public long getId(Protein protein) { // Exceptions omitted...
        getProteinId.setString(1, protein.get_primary_id());
        ResultSet result = getProteinId.executeQuery();
        try {
            result.next();
            return result.getLong(1);
        } finally {
            result.close();
        }
    }
    public void insertAnnotation(int GOId, long proteinId, String ontologyId) {
        insertAnnotation.setInt(1, GOId);          // type may be wrong
        insertAnnotation.setLong(2, proteinId);
        insertAnnotation.setString(3, ontologyId); // type may be wrong
        insertAnnotation.executeUpdate();
    }
}
private void loadAnnotations(InteractionNetwork network) throws SQLException {
    connection.setAutoCommit(false);
    DatabaseInterface dbi = new DatabaseInterface();
    for(common.Protein protein : network.get_protein_vector()) {
        dbi.insertAnnotation(..., dbi.getId(protein), ...);
    }
    connection.commit();
    connection.setAutoCommit(true);
}