CREATE OR REPLACE FUNCTION doquery(_idTable bigint)
  RETURNS TABLE(idTable bigint, name varchar) AS
$BODY$
BEGIN
    RETURN QUERY EXECUTE '
       SELECT * 
       FROM table
       WHERE idTable = $1'
    USING _idTable;
END
$BODY$
  LANGUAGE plpgsql;