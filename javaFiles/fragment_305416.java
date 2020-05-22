CREATE OR REPLACE
FUNCTION delete_record (
   p_table  IN VARCHAR2,
   p_column IN VARCHAR2,
   p_value  IN VARCHAR2
)
RETURN NUMBER
AS
   v_table   user_tables.table_name%TYPE;
   v_columns user_tab_cols.column_name%TYPE;
BEGIN
   -- Check table exists in DB
   SELECT table_name
     INTO v_table
     FROM user_tables
    WHERE table_name = UPPER(p_table);

   -- Check column exists in DB table
   SELECT column_name
     INTO v_colums
     FROM user_tab_cols
    WHERE table_name = UPPER(p_table)
      AND column_name = UPPER(p_column);

   EXECUTE IMMEDIATE 
      'DELETE FROM '||DBMS_ASSERT.SIMPLE_SQL_NAME(p_table)||
      ' WHERE '||DBMS_ASSERT.SIMPLE_SQL_NAME(p_column)||' = :col_value'
     USING p_value;

   RETURN SQL%ROWCOUNT;
EXCEPTION
   WHEN NO_DATA_FOUND
   THEN
        -- Either return -1 (error) or log an error etc.
        RETURN -1;
   WHEN others
   THEN
        <Your exception handling here>
END delete_record;
/