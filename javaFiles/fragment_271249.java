BoolQueryBuilder qBool = new BoolQueryBuilder();
TermQueryBuilder query = new TermQueryBuilder("exgroups", exchangeGroup.getCode());

qBool.must(query);

ScriptQueryBuilder sQuery = new ScriptQueryBuilder(new Script("doc['exgroups'].values.length == 1"));

qBool.filter(sQuery);