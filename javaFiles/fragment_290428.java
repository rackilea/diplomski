CREATE OR REPLACE FUNCTION doquery(_idTable bigint)
  RETURNS TABLE(idTable bigint, name varchar) AS
$BODY$
BEGIN
    RETURN QUERY 
       SELECT * 
       FROM table
       WHERE idTable = _idTable;
END
$BODY$
  LANGUAGE plpgsql;