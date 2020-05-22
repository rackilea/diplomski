RewriteMap forwardURL "prg:\"C:/Program Files/Java/jdk1.6.0_11/bin/java.exe\" -jar \"C:/app/Mapper.jar\""

RewriteLock bin\map.sub.lock

RewriteCond %{REQUEST_FILENAME} !-f
RewriteCond %{REQUEST_FILENAME} !-d
RewriteRule ^/SomeScript.asp(.*)$ ${forwardURL:%{QUERY_STRING}} [L]
RewriteRule ^(.*)$ - [F]