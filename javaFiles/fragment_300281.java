pepe=> select fullname from tl_2009_06075_areawater 
where the_geom &&
ST_GeomFromText('POINT(-122.492983 37.717753)', 4269);

   fullname    
---------------
 Lk Merced

 Pacific Ocean