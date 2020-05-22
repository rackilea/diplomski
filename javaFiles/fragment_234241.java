public void process(Exchange exchange) throws Exception {       
    ...
    Map<String, Object> headers = exchange.getIn().getHeaders(); 
    headers.put("flag", Boolean.TRUE);    

    exchange.getOut().setHeaders(headers);        
    ...
}