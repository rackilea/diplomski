@WebMethod(operationName = "getStuff")
@WebResult(name = "result")
 Mix getStuff(
    @WebParam(name = "string1") String one,
    @WebParam(name = "string2") String two,
    @WebParam(name = "stuff") java.util.List<Stuff> stuff
);