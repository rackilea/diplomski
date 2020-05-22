mongo --authenticationDatabase db_name -u username -p password
(Connected to Mongo CLI client...)
> use test-db;
> db.createUser( 
  { 
    "user" : "admin", 
    "pwd": "password",  
    "roles" : [      
      { role: "root", db: "admin" },
      { role: "readWrite", db: "admin" }, 
      { role: "dbAdmin", db: "admin" },
      { role: "readWrite", db: "test_db" }, 
      { role: "dbAdmin", db: "test_db" }
    ]  
});
(Success...)
> db.auth("admin","password")
1