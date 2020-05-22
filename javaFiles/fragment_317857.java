greaterQuery.put("updated_at", gEQuery);
    lessQuery.put("updated_at", lEQuery);
    orqueryList.add(greaterQuery);
    orqueryList.add(lessQuery);

  }
  query.put("$or", orqueryList);