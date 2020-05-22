connect
username:
password:
"connected"
create user rani identifed by pcs;
grant connect, resource to rani;
"granted"
create table reg(pid integer primary key,name varchar2(50));
"table created"