create table t42 (id number);
create view v42 as select * from t42;
create trigger v42_trig instead of insert on v42 for each row
begin
  dbms_output.put_line('Instead-of trigger fired for ID: ' || :new.id);
end;
/

set serveroutput on