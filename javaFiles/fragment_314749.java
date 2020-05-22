@WebMethod(operationName = "operation")
public boolean operation(@WebParam(name = "SKU") String SKU, @WebParam(name = "fecha") String fecha, @WebParam(name = "num_captura") String num_captura, @WebParam(name = "peso_captura") int peso_captura) {
    //TODO write your implementation code here:
     Operaciones op = new Operaciones();
    return op.registra_rechazo(SKU,fecha,num_captura,peso_captura);
}