ctx.update(enrollment)        
    .set(enrollment.EXAM_PASSED, passed)
    .from(joined)
    .where(student.LASTNAME.in(studentName))
    .and(enrollment.YEAR.eq(year))
    .and(enrollment.LECTURE_ID.eq(BigInteger.valueOf(lidx)))
    .execute();