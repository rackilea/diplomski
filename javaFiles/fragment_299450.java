DECLARE
   USER_COUNT   INTEGER;
BEGIN
   SELECT COUNT (*)
     INTO USER_COUNT
     FROM dba_users
    WHERE username =?;
  IF USER_COUNT = 0 THEN

    EXECUTE IMMEDIATE 'CREATE USER  '||?|| 'IDENTIFIED BY  '||?;
    EXECUTE IMMEDIATE 'GRANT CREATE SESSION, CREATE TABLE, CREATE ANY INDEX TO  '|| ?;
  ELSE
    raise_application_error(-20101, 'User ? already exists. Please drop it or choose another username.');
  END IF;
END;
/