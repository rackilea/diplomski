// Note: you have an error in the @Select line => maps to VARCHAR not "String"
@Select(value = "{call Get_AccountList(#{accountType, mode=IN, jdbcType=VARCHAR})}")
@Options(statementType = StatementType.CALLABLE)
@Results(value = {
  @org.apache.ibatis.annotations.Result
      (property = "accountID", column = "Account_ID"),
  @org.apache.ibatis.annotations.Result
      (property = "accountName", column = "Organization_Name"),
  @org.apache.ibatis.annotations.Result
      (property = "address", column = "State", typeHandler=OrgAddressTypeHandler.class)
  })
List<Account> getAccountList(Param param);