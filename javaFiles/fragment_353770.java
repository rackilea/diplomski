CREATE OR REPLACE PROCEDURE sample_procedure ( 
   p_some_select_sql_result OUT SYS_REFCURSOR 
) 
AS 
BEGIN
   OPEN p_some_select_sql_result FOR
      SELECT ...
      FROM ...
      JOIN ...
      ... etc.;
END;
/