// variables
    selector = and(
            gt("Movie_year", 1960),
            eq("Person_name", "Alec Guinness"));
    Sort sort = Sort.desc("Movie_year");
    String[] field = {"Movie_name", "Movie_year"};
    int limit = 10;
    int skip = 0;
    // create query Builder 
    queryBuilder = new QueryBuilder(
            selector).
            sort(sort).
            fields(field).
            limit(limit).
            skip(skip);