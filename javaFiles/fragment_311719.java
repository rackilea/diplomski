dsl.selectDistinct(STUFF.FIELD)
   .from(STUFF)
   .fetchLazy()
   .stream()
   .map(r -> r.into(Something.class))
   .iterator();