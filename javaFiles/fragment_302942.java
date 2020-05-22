protected T doWrap(D d) {
    Class<T> type=getActualT();
    MethodHandles.Lookup l=MethodHandles.lookup();
    try
    {
        MethodType fType = MethodType.methodType(D.class);
        MethodType tType = fType.appendParameterTypes(D.class);
        return type.cast(LambdaMetafactory.metafactory(l, "getWrapped",
            tType.changeReturnType(type), fType,
            l.findStatic(DWrapperFactory.class, "lambda$doWrap$0", tType), fType)
            .getTarget().invoke(d));
    }
    catch(RuntimeException|Error t) { throw t; }
    catch(Throwable t) { throw new IllegalStateException(t); }
}
private static D lambda$doWrap$0(D d) {
    return d;
}