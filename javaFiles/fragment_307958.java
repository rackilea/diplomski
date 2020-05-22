private static final String UPDATE_USER_QUERY= "UPDATE  User_Information uInfo SET address = uInfo.contact_number || uInfo.address where uInfo.user_id between ? AND ?;";
//pst = connection.prepareStatement(UPDATE_USER_QUERY,columnNames);
pst = connection.prepareStatement(UPDATE_USER_QUERY,Statement.RETURN_GENERATED_KEYS);
ResultSet rst = pst.getGeneratedKeys();
List<UserInformation> userInformationList = new ArrayList<UserInformation>();
UserInformation userInformation;

while (rst.next()){
 userInformation = new UserInformation();

 userInformation.setUserId(rst.getLong("user_id"));
 userInformation.setUserName(rst.getString("user_name"));
 userInformation.setUserLName(rst.getString("user_lName"));
 userInformation.setAddress(rst.getString("address"));
 userInformation.setContactNumber(rst.getLong("contact_number"));
 userInformationList.add(userInformation);
}