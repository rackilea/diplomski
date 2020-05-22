ResultSet insideResultsSet = insideStatement.executeQuery(
    "SELECT resp_authority_id " +
    "FROM resp_authority_to_ps " +
    "WHERE ps_code = " + PlannetSchemeCode
);

if (insideResultsSet.next()) {
    ResponcibleAuthorityID = insideResultsSet.getInt("resp_authority_id");

    // etc...
}