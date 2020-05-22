public enum SPARQLENUM {
    MARK_SIMPLE_TYPE(new SparqlResource("ldmext/MarkSimpleType.rq")) ,
    FORTRESS_HAS_ENVOY(new SparqlResource("ldmext/FortressHasEnvoy.rq")) ,
    FORTRESS_HAS_GUARD(new SparqlResource("ldmext/FortressHasGuard.rq")) ,
    FORTRESS_HAS_PORT(new SparqlResource("ldmext/FortressHasPort.rq"));

    private SparqlResource value;

    private SPARQLENUM(SparqlResource value) {
        this.value = value;
    }


    public SparqlResource getValue(){
        return value;
    }


}