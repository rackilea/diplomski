DECLARE
  l_str_wo_spaces VARCHAR2(8) := 'jibbyj';
  l_str_w_spaces  VARCHAR2(8) := 'jibbyj  ';
  l_cnt           INTEGER;
BEGIN
  -- This will find no rows
  SELECT COUNT(*)
    INTO l_cnt
    FROM your_table
   WHERE char_column = l_str_wo_spaces;
  dbms_output.put_line( l_cnt );

  -- This will find a row because it has the extra spaces
  SELECT COUNT(*)
    INTO l_cnt
    FROM your_table
   WHERE char_column = l_str_w_spaces;
  dbms_output.put_line( l_cnt );
END;