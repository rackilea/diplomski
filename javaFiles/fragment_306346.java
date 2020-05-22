ctx.select(AT_TRAIL.POINT)
   .from(AT_TRAIL)
   .where(AT_TRAIL.ID.le(
      select(AT_TRAIL.ID) // Now, no scoping problem anymore
     .from(AT_TRAIL)
     .orderBy(field("{0} <-> {1}", // jOOQ doesn't support this op, resorting to plain SQL
        AT_TRAIL.POINT,
        select(AT_SHELTER.POINT)
       .from(AT_SHELTER)
       .where(AT_SHELTER.ID.eq(
          select(AT_LAST_SHELTER.AT_SHELTER)
         .from(AT_LAST_SHELTER)
       ))
     ).asc())
     .limit(1)
   ))
   .orderBy(AT_TRAIL.ID.asc())
   .fetch();