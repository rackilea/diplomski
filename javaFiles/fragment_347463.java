# .htaccess file contents
# Apache has the same docroot as the Java web app.
# Java webapp is running on port 8084
<IfModule mod_rewrite.c>
RewriteEngine On
RewriteBase /
RewriteCond %{REQUEST_FILENAME} !-f [NC,OR]
RewriteCond %{REQUEST_FILENAME} !-d
# directory where images, static html files and JS scripts are located.
# Apache will serve these.
RewriteRule ^resources - [L,NC]
# obviously, we want Apache to serve robots.txt
RewriteRule ^robots.txt$ - [L,NC]
RewriteRule ^(.*)$ http://localhost:8084/Dispatcher?q=$1 [L,P,QSA]
</IfModule>