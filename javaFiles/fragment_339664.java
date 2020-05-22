post("/receive-sms", (req, res)-> {                         <-- Method 4
    // This gets the message content
    System.out.println(req.queryParams("Body"));            
    // GOT CONTENT
    // Must parse the format and get the content value
    // Must be able to get the latest message

    // do something with the content

    MessagingResponse twiml = new MessagingResponse.Builder().build();
    return twiml.toXml();
});