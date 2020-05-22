CREATE OR REPLACE FUNCTION get_geom_difference()
   RETURNS integer AS
$BODY$
   SELECT num
   FROM   filedata
   WHERE  num = 1 
   LIMIT  1;  -- needed if there can be more than one rows with num = 1
$BODY$    LANGUAGE SQL;