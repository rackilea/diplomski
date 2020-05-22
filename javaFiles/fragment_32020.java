public ParentException managedException(Exception cause) {        
    if(ExceptionA.class.isInstance(cause)) {
        return ExceptionA.class.cast(cause);
    } else if(ExceptionB.class.isInstance(cause)) {
        return ExceptionB.class.cast(cause);
    } else if(ExceptionC.class.isInstance(cause)){
        return ExceptionC.class.cast(cause);
    } else {
        return new ExceptionD(cause.getMessage(), cause);
    }
}