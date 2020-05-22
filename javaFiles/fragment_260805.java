public final void writeEnabled(){
    getSession().doWork(jdbcWorkWriteEnabled);
}

public final void writeDisabled(boolean flush){
    if(flush)
        flush();
    getSession().doWork(jdbcWorkWriteDisabled);
}

public static final void writeEnabled(Session session){
    session.doWork(jdbcWorkWriteEnabled);
}

public static final void writeDisabled(boolean flush,Session session){
    if(flush)
        session.flush();
    session.doWork(jdbcWorkWriteDisabled);
}

final static Work jdbcWorkWriteEnabled = new Work(){
    public void execute(Connection connection) throws SQLException {
        connection.setReadOnly(false);
    }
};

final static Work jdbcWorkWriteDisabled = new Work(){
    public void execute(Connection connection) throws SQLException {
        connection.setReadOnly(true);
    }
};