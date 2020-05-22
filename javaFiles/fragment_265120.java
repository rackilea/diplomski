// Get access to the "model API" from a statement without any SELECT fields
SelectQuery<?> select =
create.select()
      .from( TABLE1 )
      .join( TABLE2 ).on( TABLE1.ID.equal( TABLE2.ID ))
      .join( TABLE3 ).on( TABLE1.OTHER_ID.equal( TABLE3.OTHER_ID ))
      .getQuery();

// Copy all fields from the SELECT statement:
List<Field<?>> fields = new ArrayList<>(select.getSelect());

// And explicitly add them:
select.addSelect(fields);
select.addSelect(count().over());