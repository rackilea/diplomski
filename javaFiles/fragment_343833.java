protected String authRequest(String userSuppliedString, String returnToUrl)
    throws IOException
{
    ...
   // Attribute Exchange example: fetching the 'email' attribute
   FetchRequest fetch = FetchRequest.createFetchRequest();
   fetch.addAttribute("email",
                      "http://schema.openid.net/contact/email",   // type URI
                      true);                                      // required