.process(new Processor() {
    @Override
    public void process(Exchange exchange) throws Exception {
        exchange.setProperty("myHackProperty", String.format("sftp://{{hostname}}:{{port}}/%s)", exchange.getProperty("dest‌‌​​inationDir")) 
    }
}

.recipientList(exchangeProperty("myHackProperty"))