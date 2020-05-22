class ResponseItem {
    public ResponseItemVO toVO(){
        ResponseItemVO ret = new ResponseItemVO();
        ret.setErrorDetails(getErrorDetails());
        ret.setResult(getResult().toVO());
        ret.setIdentifier(getIdentifier().toVO());
        return ret;
    }
}