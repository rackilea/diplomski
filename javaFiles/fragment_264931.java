input {
  jdbc {
    jdbc_driver_library => "ojdbc6.jar"
    jdbc_driver_class => "oracle.jdbc.OracleDriver"
    jdbc_connection_string => "jdbc:oracle:thin:@localhost:1521/mydb"
    jdbc_user => "user"
    jdbc_password => "password"
    statement => "SELECT * FROM my_table"
  }
}

output {
  elasticsearch {
    hosts => ["localhost:9200"]
    index => "my_index"
  }
}