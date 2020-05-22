Map<UserPojo, List<RolePojo>> result =
dsl.select(USER.fields())
   .select(ROLE.fields())
   .from(USER)
   .join(USER_TO_ROLE).on(USER.USER_ID.eq(USER_TO_ROLE.USER_ID))
   .join(ROLE).on(ROLE.ROLE_ID.eq(USER_TO_ROLE.ROLE_ID))
   .where(USER.U_EMAIL.equal(email))
   .fetchGroups(

       // Map records first into the USER table and then into the key POJO type
       r -> r.into(USER).into(UserPojo.class),

       // Map records first into the ROLE table and then into the value POJO type
       r -> r.into(ROLE).into(RolePojo.class)
   );