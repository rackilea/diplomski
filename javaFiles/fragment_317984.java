@Webservice
public Class CalculatorWS
{

    @WebMethod
    public int add(@WebParam(name = "i") int i, @WebParam(name = "j") int j) {
        int k = i + j;
        return k;
    }
}