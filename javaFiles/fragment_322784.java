public enum ProtocolOperation {

    CREATE(1){
        @Override
        public HttpMethodName getHttpMethodName(){
            return HttpMethodName.POST; 
        }
    },
    RETRIEVE(2){
        @Override
        public HttpMethodName getHttpMethodName(){
            return HttpMethodName.GET;  
        }
    },
    UPDATE(3){
        @Override
        public HttpMethodName getHttpMethodName(){
            return HttpMethodName.PUT;  
        }
    },
    DELETE(4){
        @Override
        public HttpMethodName getHttpMethodName(){
            return HttpMethodName.DELETE;   
        }
    },
    NOTIFY(5){
        @Override
        public HttpMethodName getHttpMethodName(){
            return HttpMethodName.POST; 
        }
    };


    private BigInteger operationId;


    public BigInteger getOperationId() {
        return operationId;
    }

    private ProtocolOperation(int operationId) {
        this.operationId = BigInteger.valueOf(operationId);
    }

   abstract public HttpMethodName getHttpMethodName();
}