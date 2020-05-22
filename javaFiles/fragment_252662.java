CREATE OR REPLACE FUNCTION get_geom_difference()
  RETURNS TABLE (num mumeric, my_area geometry) AS
$BODY$
   SELECT f.num
         ,st_area(ST_Difference(ST_TRANSFORM(f.the_geom, 70066), t.the_geom))
   FROM   filedata f
   JOIN   filedata_temp t USING (num);
$BODY$
LANGUAGE sql;