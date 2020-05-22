@echo off
set APP_USER=%1
set APP_PASSWORD=%2
set APP_DIR=%3
set CLASSPATH=%CLASSPATH%;$IA_CLASSPATH$;./lib/myapp.jar

cd %APP_DIR%

java -cp %CLASSPATH% com.example.myapp.Main %APP_USER% %APP_PASSWORD%