ctx.update(enrollment)        
    .set(enrollment.EXAM_PASSED, passed)
    .where(enrollment.STUDENT_ID.in(
        select(student.ID)
        .from(student)
        .and(student.LASTNAME.in(studentName))
    ))
    .and(enrollment.YEAR.eq(year))
    .and(enrollment.LECTURE_ID.eq(BigInteger.valueOf(lidx)))
    .execute();