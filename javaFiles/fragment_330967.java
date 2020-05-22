MERGE INTO mytable d
USING ( SELECT 11 AS id, 'x1' AS t1 FROM DUAL ) s
      ON ( d.id = s.id )
WHEN NOT MATCHED THEN
  INSERT ( d.id, d.t1 ) VALUES ( s.id, s.t1 )
WHEN MATCHED THEN
  UPDATE SET d.t1 = s.t1;