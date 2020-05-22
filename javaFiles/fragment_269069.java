using(configuration)
  .select(COMPANY.NAME, inline("companyType").as("resultType"))
  .from(COMPANY)
  .unionAll(
   select(USER.NAME, inline("userType").as("resultType"))
  .from(USER))
  .fetch();