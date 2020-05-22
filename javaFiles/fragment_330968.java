DECLARE
  p_id MYTABLE.ID%TYPE := 11;
  p_t1 MYTABLE.T1%TYPE := 'x1';
BEGIN
  UPDATE mytable
  SET    t1 = p_t1
  WHERE  id = p_id;

  IF SQL%ROWCOUNT = 0 THEN
    INSERT INTO mytable ( id, t1 ) VALUES ( p_id, p_t1 );
  END IF;
END;
/