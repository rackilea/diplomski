DEMILITER //
CREATE TRIGGER ai_tbl_name AFTER INSERT ON tbl_name
FOR EACH ROW
BEGIN

SET @TimeStamp = NEW.timestamp_column;

END;//
DELIMITER ;