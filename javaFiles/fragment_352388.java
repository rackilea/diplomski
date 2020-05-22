CREATE OR REPLACE TRIGGER t1_version
AFTER INSERT OR UPDATE ON t1
FOR EACH ROW
BEGIN
    IF :new.version_no IS NULL THEN
       :new.version_no  := 0;
    ELSE
       :new.version_no  := :old.version_no  + 1;
    END IF;
END;