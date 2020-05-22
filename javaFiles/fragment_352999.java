from("direct:start")
  .setBody(constant("select customer.id as ID from customer where customer.name = 'ABC'"))
  .to("jdbc:myDataSource")

  //now, use simple/ognl to extract the first result and the 'ID' from the Map in the body
  .setBody(simple("select account.id from account where account.custid in ${body[0][ID]}"))
  .to("jdbc:myDataSource")

  .log("ACCOUNT IDS = ${body}");