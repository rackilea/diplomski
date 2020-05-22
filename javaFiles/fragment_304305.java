Result<?> result = sql
    .select()
    .from(SCHEUDLE)
    .leftOuterJoin(COURSE)
    .on(SCHEDULE.CID.eq(COURSE.ID))
    .leftOuterJoin(STUDENT)
    .on(SCHEDULE.SID.eq(STUDENT.ID))
    .fetch();