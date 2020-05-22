DELIMITER $$
CREATE PROCEDURE p_update_Master_Name
(
    IN tbl_Name VARCHAR(35),
    IN tbl_column_old_value VARCHAR(35),
    IN tbl_column_new_value VARCHAR(35),
    IN tbl_user_id INT,
    OUT msg INT 
)
BEGIN
    SET @sql = CONCAT('SELECT (COUNT(*) > 0) INTO @result FROM ', tbl_name, ' WHERE Name = \'', tbl_column_new_value, '\'');
    PREPARE stmt FROM @sql;
    EXECUTE stmt;

    SET msg = @result;

    IF @result = 0 THEN
      SET @sql = CONCAT('UPDATE ', tbl_name, 
                        ' SET Name = \'', tbl_column_new_value, 
                        '\', Modified_Date = NOW(), Modified_by = ', tbl_user_id, 
                        ' WHERE Name = \'', tbl_column_old_value, ' \'');
      PREPARE stmt FROM @sql;
      EXECUTE stmt;
    END IF;
    DEALLOCATE PREPARE stmt;
END$$
DELIMITER ;