package pkg.ws;

import javax.jws.WebService;
import pkg.ex.FooException;

@WebService(serviceName = "FooSvc")
public class FooService {

    public String sayHello(String name) throws FooException {
        if (name.isEmpty()) {
            Throwable t = new IllegalArgumentException("Empty name");
            throw new FooException("There is one error", t);
        }
        return "Hello, " + name;
    }

}