datasources = {
    datasource(name: 'my_schemas') {
        domainClasses([Question, Answer, Genre])
        driverClassName('com.mysql.jdbc.Driver')
        url('jdbc:mysql://test.myserver.com')
        username('***')
        password('***')
    }
}