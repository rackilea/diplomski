CREATE TABLE IF NOT EXISTS users (
     username VARCHAR(10) NOT NULL,  
     password VARCHAR(32) NOT NULL,
     enabled BOOLEAN NOT NULL,
     PRIMARY KEY (username)  
);  

CREATE TABLE IF NOT EXISTS authorities (  
     username VARCHAR(10) NOT NULL,  
     authority VARCHAR(10) NOT NULL,  
     FOREIGN KEY (username) REFERENCES users(username)
); 

insert into users(username,password,enabled) values ('abc','123456',TRUE);   
insert into authorities(username,AUTHORITY) values ('abc', 'ROLE_USER');