ctx.getRequest().getBody().then({ data ->
  String text = data.getText();
  // parse text with whatever you use, e.g. Jackson

  System.out.println("Getting value");
  response.send("webshop.html"); 
})