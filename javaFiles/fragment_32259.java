DELIMITER //
DROP PROCEDURE IF EXISTS sp_procedure_name //
CREATE PROCEDURE sp_procedure_name (IN col1_val VARCHAR(25),
                                    IN col2_val VARCHAR(25),
                                    IN col3_val INT)
BEGIN
    INSERT INTO tbl_name (col1, col2, col3)
    VALUES (col1_val, col2_val, col3_val);

    SELECT @TimeStamp;
END; //
DELIMITER ;