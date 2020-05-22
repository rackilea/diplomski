jpa.default=readwritePU

db {
    default {
        hikaricp {
            dataSourceClassName=org.postgresql.ds.PGSimpleDataSource
            dataSource {
                serverName = localhost
                databaseName = "mydbname"
                user = "postgres"
                password = "123456"
            }
        }
        jndiName=ReadWriteDS
    }
}