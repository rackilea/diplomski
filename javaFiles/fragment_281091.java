public class YourProxyClass : SoapHttpClientProtocol
{
    protected override WebResponse GetWebResponse(WebRequest request)
    {
        var response = base.GetWebResponse(request);
        response.Headers["Content-Type"] = "text/xml; charset=utf-8"; //<==
        return response;

    }
}