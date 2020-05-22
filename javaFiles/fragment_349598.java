input {
    jdbc {
        jdbc_connection_string => "jdbc:mysql://yourhost:3306/yourdb" 
        jdbc_user => "root"
        jdbc_password => "root"
        jdbc_validate_connection => true
        jdbc_driver_library => "/pathtojar/mysql-connector-java-5.1.39-bin.jar"
        jdbc_driver_class => "com.mysql.jdbc.Driver"
        schedule => "* * * * *" <-- if you need the query to be running continuously at a time span 
        statement => "SELECT * FROM yourtable" <-- change the query to your need        
        jdbc_paging_enabled => "true"
        jdbc_page_size => "50000"
    }
}