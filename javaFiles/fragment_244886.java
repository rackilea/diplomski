Query luceneQuery = queryBuilder
    .keyword()
      .wildcard()
    .onField("foo")
    .matching("bar*")
    .createQuery();