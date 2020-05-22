WSRequestHolder requestHolder = WS.url("https://application.url/ws/endpoint")
            .setHeader("Content-Type", "application/json");
final Promise<WS.Response> promise = requestHolder.get();
Response myResponse=promise.get(50000); 
// This code returns the Parsed response in form of String
return myResponse.getBody();