String = "new File";
String userEmail= new CurrentUser ().getUser ().getEmail ();

String body = "<?xml version='1.0' encoding='UTF-8'?>"
      + "<entry xmlns=\"http://www.w3.org/2005/Atom\">"
      + "<id>t7Z3GLNuO641hOO737UH60Q</id>"
      + "<title>"+ title +"</title>"
      + "</entry>";

try {
  GDataRequest gdr = docsService.createRequest(Service.GDataRequest.RequestType.INSERT,
    new URL("https://docs.google.com/feeds/default/private/full/?xoauth_requestor_id="+ userEmail),
    ContentType.ATOM);

  gdr.setHeader("GData-Version", "3.0");
  OutputStream requestStream = gdr.getRequestStream();
  requestStream.write(body.getBytes());

  log.info(gdr.toString());
  gdr.execute();    
}
[.. catch]