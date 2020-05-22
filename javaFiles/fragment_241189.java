CREATE TABLE TableName ( 
    T1 varchar(50),
    T2 varchar(50),
    foreign key(T1) references Table1(T1),
    foreign key(T2) references Table2(T2) 
);