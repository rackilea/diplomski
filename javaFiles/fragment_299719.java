DECLARE 
  table_count NUMBER;
  curr_user VARCHAR2(100);  
BEGIN
  SELECT
  sys_context('USERENV','SESSION_USER') INTO curr_user 
  FROM dual;

  SELECT count(*)
  INTO table_count
  FROM all_objects
  WHERE object_type IN ('TABLE', 'VIEW')
  AND object_name = UPPER('main_table')
  AND owner = curr_user;

  IF table_count > 0 THEN

    EXECUTE IMMEDIATE q'{
    BEGIN
      EXECUTE IMMEDIATE 'TRUNCATE TABLE some_table_backup';
      EXECUTE IMMEDIATE 'INSERT INTO some_table_backup
          SELECT *
          FROM some_table';
      EXCEPTION
      WHEN OTHERS THEN
      IF SQLCODE != -942
      THEN
        RAISE;
      ELSE
        EXECUTE IMMEDIATE 'CREATE TABLE some_table_backup AS SELECT * FROM some_table';
      END IF;
    END;}';

    EXECUTE IMMEDIATE q'{
    BEGIN
      EXECUTE IMMEDIATE 'TRUNCATE TABLE some_table_backup2';
      EXECUTE IMMEDIATE 'INSERT INTO some_table_backup2
          SELECT *
          FROM some_table2';
      EXCEPTION
      WHEN OTHERS THEN
      IF SQLCODE != -942
      THEN
        RAISE;
      ELSE
        EXECUTE IMMEDIATE 'CREATE TABLE some_table_backup2 AS SELECT * FROM some_table2';
      END IF;
    END;}';   

  END IF;

EXCEPTION
  WHEN OTHERS
  THEN
  DBMS_OUTPUT.put_line(SQLERRM);
END;