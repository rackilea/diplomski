// This is just to have some relatively large ammount of data to insert in the BLOB, details don't matter
private static final byte[] LARGE_DATA.getBytes(StandardCharsets.UTF_8);
static {
    final StringBuilder builder = new StringBuilder(10000);
    for (int i = 0; i < 4000; i++) {
        builder.append('a');
    }
    LARGE_STRING = builder.toString();
}

from("direct:clobTest")
.process(new Processor() {
    @Override
    public void process(Exchange exchange) throws Exception {
        exchange.getIn().setHeader("myParam", LARGE_DATA);
    }
})
.to("sql:INSERT INTO clob_table(clob_col) VALUES(:#myParam)");