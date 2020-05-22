production {
    dataSource {
        dbCreate = "update"
        url = "jdbc:hsqldb:file:prodDb;shutdown=true"
    }
}