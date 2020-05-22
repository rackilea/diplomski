public class MyClientServiceImpl implements MyClientService {

    @WebServiceRef(wsdlLocation = "http://localhost:8080/calculator?wsdl", 
value = CalculatorService.class)
    private Calculator service;

    @Override
    public Integer add(int a , int b) {
        return service.add(a,b);
    }
}