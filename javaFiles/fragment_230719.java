ZExpert[] allZExpert = scrCalc.getzExpertAll();

for(int i = 0; i < allZExpert.length; i++) {
  ZExpert currentZExpert = allZExpert[i]; 
  int id = currentZExpert.getId();
  int domain = currentZExpert.getDomain();
  double ZExpertScore = currentZExpert.getzExpert();

  String sql = "UPDATE CUSTOMER_TABLE SET Z_EXPERT_SCORE = ? WHERE CONSUMER_EXPERT_ID= ? AND CONSUMER_ID= ?";
  PreparedStatement statement = con.prepareStatement(sql);
  statement.setDouble(1, zExpertScore);
  statement.setInt(2, domain);
  statement.setInt(3, id);
  statement.executeUpdate();
}