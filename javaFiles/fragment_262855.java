@Transactional(rollBackFor=Exception.class, Propagation=Propagation.MANDATORY)
    public Object doGenericBusinessStuff(Object o){
        service.firstOperation(o);
        service.secondOpertion(o);
        //There can be stuff here in other BusinessClass
        return o;
    }