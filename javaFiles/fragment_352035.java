DECLARE
    permissionNumber NUMBER(35);
BEGIN
    SELECT SEQ
    INTO permissionNumber
    FROM DBA_JAVA_POLICY
    WHERE TYPE_NAME LIKE ‘%File%’ AND GRANTEE = ‘ABC_DEF’;
    DBMS_JAVA.disable_permission(permissionNumber);
    DBMS_JAVA.delete_permission(permissionNumber);
END;
/