class ResponseItemVO {
    public static ResponseItemVO from(ResponseItem pArg0){
        if (pArg0==null){
            return null;
        }
        ResponseItemVO ret = new ResponseItemVO();
        ret.setErrorDetails(pArg0.getErrorDetails());
        ret.setResult(ResultVO.from(pArg0.getResult()));
        ret.setIdentifier(IdentifierVO.from(pArg0.getIdentifier()));
        return ret;
    }
}