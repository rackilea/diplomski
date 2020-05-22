public Response process(Applicant appl)
{

    String responseString;
    String requestString;
    requestString = createRequestString(appl);
    responseString = sendRequest(requestString);
    Response response = parseResponse(responseString);
    response.setResponseString(responseString);
    return response;
}