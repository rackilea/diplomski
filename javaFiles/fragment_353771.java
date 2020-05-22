CREATE OR REPLACE FUNCTION sample_function RETURN SYS_REFCURSOR
AS 
   l_some_select_sql_result
BEGIN
   OPEN l_some_select_sql_result FOR
      SELECT ...
      FROM ...
      JOIN ...
      ... etc.;

   RETURN l_some_select_sql_result;
END;
/