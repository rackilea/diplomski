Box b = BOX.as("b");
Support s = SUPPORT.as("s");

SelectSeekStep1<Integer, Integer> sql = query.select(b.ID, s.ID /* other columns */)
     .from(b)
     .join(s)
        .on(s.ID.eq(b.SUPPORT_ID))
     .where(s.ID.eq("XXXX"))
     .orderBy(b.ID)
;