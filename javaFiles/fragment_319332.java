String email = ...
int offset = ...
int limit = ...

using(configuration)
  .select(
    IMAGES.ID,
    IMAGES.URL,
    IMAGES.EMAIL,
    count().over().as("overallCount"))
  .from(IMAGES)
  .where(IMAGES.EMAIL.eq(email))
  .offset(offset)
  .limit(limit)
  .fetch();