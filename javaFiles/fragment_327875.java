public Object B() {
    //start tx
    doSomeDatabaseChange(); //quite fast

    return obj;
    // commit or rollback tx, may take time
}