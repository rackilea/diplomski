public static void saveSomethingImportantToDataBase(Object theObjectIwantToSave) {
    synchronized (theObjectIwantToSave) {
        if (!methodThatChecksThatObjectAlreadyExists) {
            storemyObject() //pseudo code
        }
        // Have to do a lot other saving stuff, because it either saves everything or nothing
        commit() // pseudo code to actually commit all my changes to the database.
    }
}