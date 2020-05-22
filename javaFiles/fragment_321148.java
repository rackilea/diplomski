try(Statement statement = conn.createStatement()){
    statement.addBatch("update people set firstname='Alice' where id=1");
    statement.addBatch("update people set firstname='Bob'   where id=2");
    statement.addBatch("update people set firstname='Chuck' where id=3");
    statement.executeBatch();
}