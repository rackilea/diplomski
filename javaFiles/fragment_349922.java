CREATE TABLE precisetimes(id NUMBER(2), precisetime TIMESTAMP(6));
insert into precisetimes values(1, TO_TIMESTAMP('2017-05-31 12:12:12.123456','YYYY-MM-DD HH:MI:SS.FF'));
insert into precisetimes values(2, TO_TIMESTAMP('2017-05-31 12:12:12.12','YYYY-MM-DD HH:MI:SS.FF'));
insert into precisetimes values(3, TO_TIMESTAMP('2017-05-31 12:12:12.123457','YYYY-MM-DD HH:MI:SS.FF'));
commit;

select id,TO_CHAR(precisetime, 'YYYY-MM-DD HH:MI:SS.FF') ptime from precisetimes;