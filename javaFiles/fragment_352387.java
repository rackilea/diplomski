BEGIN
    UPDATE t1
    SET seatTaken = true
    WHERE seatid = .....
    AND version_no = p_version
    RETURNING version_no INTO p_version;
EXCEPTION WHEN NOT_FOUND THEN
    --Generate a custom exception 
    --concurrency viloation the record has been updated already
END;