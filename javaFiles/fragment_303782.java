ctx.loadInto(AUTHOR)
   .loadCSV(csv)
   .fields(AUTHOR.ID, AUTHOR.FIRST_NAME, AUTHOR.LAST_NAME)
   .values(
      row -> AUTHOR.ID.getDataType().convert(row[0]),
      row -> row[1].split(" ")[0],
      row -> row[1].split(" ")[1]
   )
   .execute();