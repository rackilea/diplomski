interface Request {}

interface Response {
    public String sayHi();
}

class DeviceRequest implements Request {}
class DeviceResponse implements Response{
    public String sayHi() { return "DeviceResponse"; }
}

class WebRequest implements Request {}
class WebResponse implements Response{
    public String sayHi() { return "WebResponse"; }
}

class Helper {
    private <T extends Response> T execute(Request request, Class<T> clazz) throws InstantiationException, IllegalAccessException {
        return clazz.newInstance();
    }
    public DeviceResponse foo(DeviceRequest request) throws InstantiationException, IllegalAccessException {
        return execute(request, DeviceResponse.class);
    }
    public WebResponse bar(WebRequest request) throws InstantiationException, IllegalAccessException {
        return execute(request, WebResponse.class);
    }
}

class Consumer {
    public void baz() throws InstantiationException, IllegalAccessException {
        Helper helper = new Helper();
        DeviceResponse dr = helper.foo(new DeviceRequest());
        WebResponse wr = helper.bar(new WebRequest());
        System.out.println(dr.sayHi());
        System.out.println(wr.sayHi());
    }
    public static void main(String[] args) throws Exception {
        new Consumer().baz();
    }
}