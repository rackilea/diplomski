from("direct:start")
.to("bean:sqlBean?method=generateSqlQuery('tablename')")
.to("jdbc:datasource")
.process( new Processor () {

    @Override
    public void process(Exchange exchange) throws Exception {
        exchange.getOut().toString();

    }});