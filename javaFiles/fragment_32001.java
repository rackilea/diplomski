production {
    dataSource {
        dbCreate = "update"
        url = "jdbc:hsqldb:file:/some/writeable/folder/prodDb;shutdown=true"
    }
}