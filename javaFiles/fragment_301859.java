String defaultField = ...;
Analyzer analyzer = ...;
QueryParser queryParser = new QueryParser(defaultField, analyzer);

queryParser.setDefaultOperator(QueryParser.Operator.AND);

Query query = queryParser.parse("Searching is fun");