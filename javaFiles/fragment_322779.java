class Mapping {
    public static ResponseItemVO convertResponseItem(ResponseItem pArg0){
        if (pArg0==null){
            return null;
        }
        ResponseItemVO ret = new ResponseItemVO();
        ret.setErrorDetails(pArg0.getErrorDetails());
        ret.setResult(Mapping.convertResult(pArg0.getResult()));
        ret.setIdentifier(Mapping.convertIdentifier(pArg0.getIdentifier()));
        return ret;
    }
}