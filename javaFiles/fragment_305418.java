EXECUTE IMMEDIATE 
  'DELETE FROM '||DBMS_ASSERT.SIMPLE_SQL_NAME(p_table)||
  ' WHERE '||DBMS_ASSERT.SIMPLE_SQL_NAME(p_column)||' = :col_value'||
  ' AND date BETWEEN :date_from AND :date_to'
 USING p_value,
       p_date_from,
       p_date_to;