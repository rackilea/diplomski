QueryBuilder queryBuilder = db.query(new QueryBuilder(and(
   gt("Movie_year", 1960),
   eq("Person_name", "Alec Guinness"))).
   sort(Sort.desc("Movie_year")).
   fields("Movie_name", "Movie_year").
   bookmark("some-bookmark").
   limit(2);