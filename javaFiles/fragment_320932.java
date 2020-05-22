QProgram program = QProgram.program
JPASubQuery subQuery = new JPASubQuery();
subQuery.from(program)
        .where(program.programType.eq(ProgramType.FULLTIME),
            program.programCost.gt(1000));

Predicate predicate = QMember.member.name.eq("John")
    .and(subQuery.exists());

memberRepository.findAll(predicate);