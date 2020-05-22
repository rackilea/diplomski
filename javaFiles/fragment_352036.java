BEGIN
   DBMS_JAVA.GRANT_PERMISSION(
      GRANTEE           => ‘ABC_DEF’,
      PERMISSION_TYPE   => ‘java.io.FilePermission’
      PERMISSION_NAME   => ABC_DEF.FILE_UTILITIES.parentFolder || ‘\-’,
      PERMISSION_ACTION => ‘execute’
  );
END;
/

BEGIN
   DBMS_JAVA.GRANT_PERMISSION(
      GRANTEE           => ‘ABC_DEF’,
      PERMISSION_TYPE   => ‘java.io.FilePermission’
      PERMISSION_NAME   => ABC_DEF.FILE_UTILITIES.parentFolder || ‘\-’,
      PERMISSION_ACTION => ‘write’
  );
END;
/

BEGIN
   DBMS_JAVA.GRANT_PERMISSION(
      GRANTEE           => ‘ABC_DEF’,
      PERMISSION_TYPE   => ‘java.io.FilePermission’
      PERMISSION_NAME   => ABC_DEF.FILE_UTILITIES.parentFolder || ‘\-’,
      PERMISSION_ACTION => ‘read’
  );
END;
/