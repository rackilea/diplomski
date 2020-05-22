PreparedStatement ps = new QueryBuilder()
   .select("*")
   .from("accounts")
   .where()
   .add(yourConstraint())
   ...
   .compile();