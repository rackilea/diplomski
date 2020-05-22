CREATE OR REPLACE FUNCTION getallentree()
  RETURNS SETOF entree AS
$BODY$
   select * from entree ; 
$BODY$
  LANGUAGE sql;