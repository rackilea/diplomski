@WebMethod
public String sayHello(@WebParam String name, @WebParam String thing)  throws MyException
{
    // TODO Auto-generated method stub
    if ("err".equals(name))
        throw new MyException("E0010","Report not found");
    return null;
}