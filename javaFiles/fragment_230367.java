public BindingOperationInfo extractBindingOperationInfo(Message message) {
    DepthXMLStreamReader xmlReader = getXMLStreamReader(message);
    DataReader<XMLStreamReader> dr = getDataReader(message);
    boolean client = isRequestor(message);
    Exchange exchange = message.getExchange();
    BindingOperationInfo bop = null;

    Service service = ServiceModelUtil.getService(message.getExchange());

    try {

        Endpoint ep = exchange.get(Endpoint.class);
        ServiceInfo si = ep.getEndpointInfo().getService();
        Collection<OperationInfo> operations = null;
        operations = new ArrayList<OperationInfo>();
        operations.addAll(si.getInterface().getOperations());

        if (xmlReader == null || !StaxUtils.toNextElement(xmlReader)) {
            // empty input
            bop = getBindingOperationForEmptyBody(operations, ep, exchange);
            return bop;
        }

        setDataReaderValidation(service, message, dr);


        QName elName = xmlReader.getName();
        bop = findMessagePart(exchange, operations, elName, client,
                 message);

    } catch (Fault f) {
        if (!isRequestor(message)) {
            f.setFaultCode(Fault.FAULT_CODE_CLIENT);
        }
        throw f;
    }

    return bop;
}