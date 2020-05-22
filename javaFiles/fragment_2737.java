delimiter ;;
CREATE PROCEDURE insert_checked_zip(zipdata int)
BEGIN
    IF (zipdata > 0) THEN
        INSERT INTO mytable (zipcode) VALUES (zipdata);
    ELSEIF
        SELECT 'zip was invalid';
    END IF;
END
;;
delimiter ;