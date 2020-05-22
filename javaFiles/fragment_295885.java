using(configuration)
  .update(TABLE)
  .set(TABLE.FIELD, 
       replace(TABLE.YOUR_FIELD, "original_string", "replace_string"))
  .where(TABLE.YOUR_FIELD.like("%original_string%"))
  .execute();