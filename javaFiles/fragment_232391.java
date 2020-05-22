create or replace FUNCTION WITHIN_DISTANCE(g sdo_geometry, lon number, lat number, distLimit number)
RETURN VARCHAR2 AS 

dist NUMBER;
result VARCHAR2(5);
tmpGeo SDO_GEOMETRY;

BEGIN
  tmpGeo := SDO_GEOMETRY(2001, 8307, SDO_POINT_TYPE(lon, lat, NULL), NULL, NULL);
  SELECT SDO_GEOM.SDO_DISTANCE(g, tmpGeo, 0.005) INTO dist FROM dual;

  IF dist <= distLimit THEN
    result := 'TRUE';
  ELSE
    result := 'FALSE';
  END IF;

  RETURN result;

END WITHIN_DISTANCE;