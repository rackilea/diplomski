package org.toto.bla;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import javax.xml.ws.Holder;
@WebService
public class WSTest {
    @WebMethod
    public void sumAndMultiplyAndReference(@WebParam(name = "firstnumber") int a, @WebParam(name = "secondnumber") int b,
                                           @WebParam(name = "referencenumber") int c,
                                           @WebParam(name = "sum", mode = WebParam.Mode.OUT) Holder<Integer> sum,
                                           @WebParam(name = "multiply", mode = WebParam.Mode.OUT) Holder<Integer> multiply,
                                           @WebParam(name = "referencenumber", mode = WebParam.Mode.OUT) Holder<Integer> reference) {
        sum.value = a + b;
        multiply.value = a * b;
        reference.value = c;
    }
}