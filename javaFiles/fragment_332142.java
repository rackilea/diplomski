create or replace procedure user(result out sys_refcursor) is
begin
    open result for
        select * from user_master;
end;
/