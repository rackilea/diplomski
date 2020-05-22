import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import javax.xml.ws.Holder;

@WebService
public class WSTest {
    @WebMethod
    public void sumAndMultiplyAndReference(@WebParam(name = "firstnumber") int a, @WebParam(name = "secondnumber") int b,
                                           @WebParam(name = "sum", mode = WebParam.Mode.OUT) Holder<Integer> sum,
                                           @WebParam(name = "multiply", mode = WebParam.Mode.OUT) Holder<Integer> multiply,
                                           @WebParam(name = "referencenumber", mode = WebParam.Mode.INOUT) Holder<Integer> c) {
        sum.value = a + b;
        multiply.value = a * b;
    }
}