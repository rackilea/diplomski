public Exchange aggregate(Exchange exchange1, Exchange exchange2) {
        if (exchange1==null){
           return exchange2;
        }
        String body1 = exchange1.getIn().getBody().toString();
        String body2 = exchange2.getIn().getBody().toString();
        String merged = body1 + "," + body2;
        exchange1.getIn().setBody(merged);
        return exchange1;
}