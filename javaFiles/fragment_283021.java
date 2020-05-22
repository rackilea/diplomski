create procedure insert_with_return_time (p_str VARCHAR2, p_time OUT DATE) as
BEGIN 
   insert into identity_pk(pad) values(p_str);
   p_time := sysdate;
END;
/