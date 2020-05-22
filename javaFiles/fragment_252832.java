dbms_java.grant_permission( '<user_name>', 'SYS:java.util.PropertyPermission', '<property_name>', 'write' );

dbms_java.grant_permission( '<user_name>', 'SYS:java.util.RuntimePermission', 'writeFileDescriptor', '' );

dbms_java.grant_permission( '<user_name>', 'SYS:java.util.RuntimePermission', 'readFileDescriptor', '' );

exec DBMS_JAVA.Grant_Permission( '<user_name>', 'SYS:java.io.FilePermission','<<ALL FILES>>','read,write,execute,delete');