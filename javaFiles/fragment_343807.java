public class Authorization {

    public static void main(String[] args) throws Exception {
        String wsdl = "http://localhost/WebService/Service?wsdl";
        String username = "user";
        String password = "password";
        String method = "foo";

        Bus bus = CXFBusFactory.getThreadDefaultBus();
        MyHTTPConduitConfigurer conf = new MyHTTPConduitConfigurer(username, password);
        bus.setExtension(conf, HTTPConduitConfigurer.class); //important: do not use your implementation class, but the interface
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance(bus);

        Client client = dcf.createClient(wsdl);

        Object[] res = client.invoke(method);

        System.out.println(Arrays.deepToString(res));
    }
}

class MyHTTPConduitConfigurer implements HTTPConduitConfigurer {

    private final String username;
    private final String password;

    public MyHTTPConduitConfigurer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void configure(String name, String address, HTTPConduit c) {
        AuthorizationPolicy ap = new AuthorizationPolicy();
        ap.setUserName(username);
        ap.setPassword(password);
        c.setAuthorization(ap);
    }
}