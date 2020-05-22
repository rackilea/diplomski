public aspect DBRowLoadSave {
    pointcut load(DBRow dbRow) :
        execution(DBRow+.new(..)) &&
        !execution(DBRow.new(..)) &&
        this(dbRow);

    after(DBRow dbRow) : load(dbRow) {
        System.out.println(thisJoinPoint);
        dbRow.load();
    }
}