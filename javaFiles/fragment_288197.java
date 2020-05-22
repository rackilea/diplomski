String sql = create.select(
                      fieldByName("BOOK","TITLE"), 
                      fieldByName("AUTHOR","FIRST_NAME"), 
                      fieldByName("AUTHOR","LAST_NAME"))
                   .from(tableByName("BOOK"))
                   .join(tableByName("AUTHOR"))
                   .on(fieldByName("BOOK", "AUTHOR_ID").equal("AUTHOR", "ID"))
                   .where(fieldByName("BOOK", "PUBLISHED_IN").equal(1948))
                   .getSQL();