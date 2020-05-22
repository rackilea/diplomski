public static void test() throws InstantiationException, IllegalAccessException {
    try {
        com.rakuten.gep.itemwrapper.external.entities.validator.NumberOfObjectsValidater.class.newInstance();
    }
    catch ( InstantiationException e ) {
        throw e;
    }    
    catch ( IllegalAccessException e ) {
        throw e;
    }
    catch ( RuntimeException e ) {
        throw e;
    }
}