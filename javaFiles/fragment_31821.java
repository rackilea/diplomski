Field<String> key = CAPABILITIES.NAME.as("key");
Field<Boolean> value = field(
  CAPABILITIES.ID.in(
    select(CAPABILITY_ID)
   .from(CAPABILITIES_USERS)
   .where(CAPABILITIES_USERS.USER_ID.eq(...))
  )
).as("value");

Map<String, Boolean> map =
DSL.using(configuration)
   .select(key, value)
   .from(CAPABILITIES)
   .fetchMap(key, value);