public enum SPARQLENUM {
    MARK_SIMPLE_TYPE("ldmext/MarkSimpleType.rq") ,
    FORTRESS_HAS_ENVOY("ldmext/FortressHasEnvoy.rq") ,
    FORTRESS_HAS_GUARD("ldmext/FortressHasGuard.rq") ,
    FORTRESS_HAS_PORT("ldmext/FortressHasPort.rq");

    private String value;

    private SPARQLENUM(String value) {
        this.value = value;
    }


    public String getValue(){
        return value;
    }


}