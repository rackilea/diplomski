Path namequery = Expressions.path(Void.class, "namequery");
query = query.leftJoin(subQuery.list(
                Expressions.path(Long.class, innerUnion, "id"),
                Expressions.path(Long.class, innerUnion, "clientid"),
                Expressions.stringPath(innerUnion, "clientname")),
              namequery)
          .on(t.id.eq(Expressions.path(Long.class, namequery, "id")));