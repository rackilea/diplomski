rs = partyPreparedStatement.executeQuery();

if (rs.next()) {
   purchaseDto.setPOIssued(true);
   // process the data here
} else {
   purchaseDto.setPOIssued(false);
}