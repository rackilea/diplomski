CREATE PROCEDURE select_companies ()
    BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE o_id SMALLINT;
    DECLARE o_name VARCHAR(52);
    DECLARE cur1 CURSOR FOR SELECT ID,NAME FROM b_company;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
    OPEN cur1;
    read_loop: LOOP
    FETCH cur1 INTO o_id, o_name;
    SELECT  o_id, o_name;
    IF done THEN
      LEAVE read_loop;
    END IF;
    END LOOP;

    CLOSE cur1;