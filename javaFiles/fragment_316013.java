CREATE SEQUENCE my_sequence;
/

CREATE OR REPLACE
PROCEDURE "TRIGGER_CALL" (p_table_name   IN VARCHAR2) 
AUTHID CURRENT_USER                          
AS 
  l_sql VARCHAR2(4000);
  l_dummy NUMBER;
  l_trigger_name VARCHAR2(30);
BEGIN
  -- Validate if a p_table_name is a valid object name
  -- If you have access you can also use DBMS_ASSERT.SQL_OBJECT_NAME procedure
  SELECT '1'
    INTO l_dummy
    FROM all_tables
   WHERE table_name = UPPER(p_table_name);

  l_trigger_name := p_table_name || '_trg'; 

  l_sql :=
    'CREATE OR replace TRIGGER ' || l_trigger_name ||
    '  BEFORE INSERT ON ' || p_table_name ||
    '  FOR EACH ROW 
     BEGIN 
       SELECT my_sequence.NEXTVAL 
       INTO   :new.sno 
       FROM   dual;
     END;';

  EXECUTE IMMEDIATE l_sql;
END; 
/

CREATE TABLE my_test(sno NUMBER);
/

BEGIN
  trigger_call('my_test');
END;
/