Capabilities c = CAPABILITIES.as("c");
CapabilitiesUsers cu = CAPABILITIES_USERS.as("cu");

Field<String> key = c.NAME.as("key");
Field<Boolean> value = nvl2(
  CAPABILITIES_USER.CAPABILITY_ID, true, false
).as("value");

Map<String, Boolean> map =
DSL.using(configuration)
   .select(key, value)
   .from(c)
   .leftOuterJoin(cu)
   .on(c.ID.eq(cu.CAPABILITY_ID))
   .and(cu.USER_ID.eq(...))
   .fetchMap(key, value);