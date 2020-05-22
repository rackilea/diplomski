@echo off

set JODA=dependency\joda-time-1.6.2.jar
set EJB=dependency\ejb-api-3.0.jar
set PERSISTANCE_API=dependency\persistence-api-1.0.jar
set DEPENDENCIES=%EJB%;%JODA%;%PERSISTANCE_API%
set TEMP_FILE=temp
set PUBLIC_INTERFACE_CLASSES=target\target-module1
set CODEGEN_CLASSES=target\target-module2
mkdir target
mkdir %MODULE1_CLASSES%
mkdir %MODULE2_CLASSES%

dir module1\*.java /s /B > %TEMP_FILE%
%JAVA_HOME_1_5%\bin\javac -classpath %DEPENDENCIES%;%MODULE1_CLASSES% -d %MODULE1_CLASSES% @%TEMP_FILE%

dir module2\*.java /s /B > %TEMP_FILE%
%JAVA_HOME_1_6%\bin\javac -classpath %DEPENDENCIES%;%JAVA_HOME_1_6%\lib\tools.jar;%MODULE1_CLASSES%;%MODULE2_CLASSES% -d %MODULE2_CLASSES% @%TEMP_FILE%

jar cf module1.jar -C %MODULE1_CLASSES% .
jar cfm module2.jar manifest.template -C %MODULE2_CLASSES% .

rm %TEMP_FILE%
rm -r target