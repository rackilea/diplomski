create table table1(a number, b number);

insert into table1
select 1, 1 from dual union all
select 2, 2 from dual;

insert all
    into table1 values(3, 3)
    into table1 values(4, 4)
select * from dual;