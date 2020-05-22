create.insertInto(table, 
          id, rollNo, name, dateEnrolled, sex)
      .values(
          "1",
          12,
          "Raman",
          new DateTime(),
          Sex.Male)
      .getSQL(ParamType.INLINED);