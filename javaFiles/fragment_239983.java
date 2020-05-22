request = (HttpURLConnection) endpointUrl.openConnection();             

request.connect(); // not really necessary (done automatically)
int statusCode = request.getResponseCode();
if (statusCode == 200) { // or maybe other 2xx codes?

    // Success - should work if server gives good response
    inputstream = request.getInputStream();

    // if you get status code 200 and still have the same error, you should
    // consider logging the stream to see what document you get from server.
    // (see below *)

    doc = dBuilder.parse(inputstream);

} else {

    // Something happened

    // handle error, try again if it makes sense, ...
    if (statusCode == 404) ... // resource not found 
    if (statusCode == 500) ... // internal server error

    // maybe there is something interesting in the body

    inputstream = request.getErrorStream();
    // read and parse errorStream (but probably this is not the body
    // you expected)

}