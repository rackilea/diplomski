create trigger triggerName before insert on alpha
    referencing new row as nuovo
        for each row
            begin atomic
                declare varCount int;
                set varCount=(select count(beta.MAINTABLEid) from beta where beta.MAINTABLEid=nuovo.MAINTABLEid);
                if varCount>0 then signal sqlstate '45000' set message_text='The row is already referenced.';
                end if;
--repeat SET and IF lines to check gamma and lambda tables
                end