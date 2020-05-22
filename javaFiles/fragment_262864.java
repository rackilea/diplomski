buildscript {
    dependencies {
        classpath 'mysql:mysql-connector-java:5.1.34'
    }
}


plugins {
    id "org.flywaydb.flyway" version "4.0.3"
}

flyway {
    url = 'jdbc:mysql://localhost:3306/mydb'
    user = 'root'
    password = 'abc!23'
    schemas = ['mydb']
    baselineVersion = 1
    baselineDescription = "Baselining myDB Schema"
}