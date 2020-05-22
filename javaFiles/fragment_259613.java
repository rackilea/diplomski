public void consumeAndForgetAllExceptions(){
    try {
        ...some code that throws exceptions
    } catch (Exception ex){
        ex.printStacktrace();
    }
}