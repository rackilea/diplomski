public enum HttpMethod
{
    GET, POST
};

@Configurable
@Default(value = "GET")
@Optional
@Placement(order = 4, group = "Connection", tab = "General")
private HttpMethod method;