CREATE OR REPLACE TRIGGER get_entry_id
  BEFORE INSERT ON entry
  FOR EACH ROW
IS
BEGIN
  SELECT entry_id_seq.nextval
    INTO :new.entry_id
    FROM dual;
END;