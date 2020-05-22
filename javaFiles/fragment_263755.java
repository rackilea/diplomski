request.addProperty("userName", "x");
request.addProperty("Password", "x");

SoapObject token = new SoapObject(NAMESPACE, "token");
token.addAttribute("Token", "your_token");
request.addSoapObject(token);