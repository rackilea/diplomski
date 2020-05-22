CREATE OR REPLACE TRIGGER  "MY_TRIGGER"
  before insert on "MYENTITY"
  for each row 
begin  
  select "MYENTITY_SEQ".curval into :NEW.BID from dual;
end;