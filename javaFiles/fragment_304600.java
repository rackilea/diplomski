public boolean onSave(Object entity,Serializable id,
    Object[] state,String[] propertyNames,Type[] types)
    throws CallbackException {

    System.out.println("onSave");

    if (entity instanceof IMarkerInterface){
        doSomethingWith(entity);
    }
    return false;
}