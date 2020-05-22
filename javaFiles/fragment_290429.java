CREATE OR REPLACE FUNCTION doquery(_idTable bigint)
  RETURNS TABLE(idTable bigint, name varchar) AS
$BODY$
   SELECT idtable, name 
   FROM table
   WHERE idTable = _idTable;
$BODY$
  LANGUAGE sql;