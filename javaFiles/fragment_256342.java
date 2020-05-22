try {
    methodThrowingALotOfDifferentExceptions();
} catch(RuntimeException ex) {
    throw ex;
} catch(Exception ex) {
    throw new MyCustomInitializationException("Class Resolver could not be initialized.", ex);
}