DSL.using(configuration)
   .select()
   .from(LIBRARY.BOOKS)
   .leftJoin(LIBRARY2.AUTHOR2)
   .on(LIBRARY.BOOKS.AUTHOR_ID.eq(LIBRARY2.AUTHOR2.ID))
   .fetch();