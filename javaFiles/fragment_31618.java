@Override
public void process(Exchange camelExchange) throws Exception {

  MessageContentsList messageBody = (MessageContentsList) camelExchange.getIn().getBody(); 

   DocumentInfo docInfoHeader = new DocumentInfo();
   ... set docInfoHeader properties ...
   messageBody.add(docInfoHeader);

}