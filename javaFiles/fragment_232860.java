CREATE OR REPLACE TRIGGER my_trigger
BEFORE INSERT
ON my_table
REFERENCING NEW AS new
FOR EACH ROW
BEGIN
    :new.create_time = SYSDATE;
END t_triggers_trigger;