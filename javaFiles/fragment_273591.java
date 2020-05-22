DBObjectMapper mapper = new DBObjectMapper("person");
   mapper.add("isEnabled", Boolean.valueOf(true);
   mapper.add("name", "doe");
   String mappedTable = mapper.getTableName();
   Boolean b = mapper.get("isEnabled");
   String string = mapper.get("name");