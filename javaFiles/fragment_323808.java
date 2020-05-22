procedure PC_INSERT_OR_UPDATE(P_ID number) as
cursor C_1 is
  select M.ID,
         C.IS_EXIST
    from MY_TABLE M
   where M.ID = P_ID;
MSG clob;
begin
for C in C_1 loop
    begin
        if C.ID is null then
            insert into MY_TABLE
                (ID,
                IS_EXIST)
            values
                (P_ID,
                1);
        elsif C.ID is not null and C.IS_EXIST = 0 then
            update MY_TABLE M
            set M.IS_EXIST = 1
            where M.ID = P_ID;
        else
            RAISE_APPLICATION_ERROR(-20001, 'My exception was raised');
        end if;
    exception
        when others then
          rollback;
          MSG := 'Error - ' || TO_CHAR(sqlcode) || ' - ' || sqlerrm;
    end;
end loop;
end;