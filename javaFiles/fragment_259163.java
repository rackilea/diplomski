String sql ="SELECT NAME, ADDRESS, COL1 FROM USER WHERE SSN IN ('11111111111111', '22222222222222');";
Select select = (Select) CCJSqlParserUtil.parse(sql);

//Start of value modification
StringBuilder buffer = new StringBuilder();
ExpressionDeParser expressionDeParser = new ExpressionDeParser() {

    @Override
    public void visit(StringValue stringValue) {
        this.getBuffer().append("XXXX");
    }

};
SelectDeParser deparser = new SelectDeParser(expressionDeParser,buffer );
expressionDeParser.setSelectVisitor(deparser);
expressionDeParser.setBuffer(buffer);
select.getSelectBody().accept(deparser);
//End of value modification 

System.out.println(buffer.toString());
//Result is: SELECT NAME, ADDRESS, COL1 FROM USER WHERE SSN IN (XXXX, XXXX)