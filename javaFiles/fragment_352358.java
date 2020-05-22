-- this grants read privilege on STDIN
EXEC dbms_java.grant_permission(
   grantee => '<username>', 
   permission_type => 'SYS:java.lang.RuntimePermission', 
   permission_name => 'readFileDescriptor', 
   permission_action => null
);

-- this grants write permission on STDOUT
EXEC dbms_java.grant_permission(
   grantee => '<username>', 
   permission_type => 'SYS:java.lang.RuntimePermission', 
   permission_name => 'writeFileDescriptor', 
   permission_action => null
);

-- this grants execute privilege for the 'ls' command
EXEC dbms_java.grant_permission(
   grantee => '<username>', 
   permission_type => 'SYS:java.io.FilePermission', 
   permission_name => '/bin/ls', 
   permission_action => 'execute'
);

-- this grants read, write, delete and execute on all 
-- of the referenced directories (subdirectories of <directory>)
EXEC dbms_java.grant_permission(
   grantee => '<username>', 
   permission_type => 'SYS:java.io.FilePermission', 
   permission_name => '<directory>/-', 
   permission_action => 'read,write,delete,execute'
);

-- this grants execute on sh
EXEC dbms_java.grant_permission(
   grantee => '<username>', 
   permission_type => 'SYS:java.io.FilePermission', 
   permission_name => '/bin/sh', 
   permission_action => 'read,execute' 
);