package foo.bar;

import javax.jws.WebService;

@WebService
public class InternalActServiceImpl {
    public Echo echo(Echo val) {
        return val;
    }
}