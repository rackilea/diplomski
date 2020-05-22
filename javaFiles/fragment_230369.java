@ECHO off
color 0E

ECHO Running prog.....
ECHO Step 1 commences....

java -cp D:\proj\bin;D:\proj\mysql-connector-java-5.1.12-bin.jar com.Class1

SET /P __ANSWER_=Do you wish to continue? (y/n)
IF /I %__ANSWER_% EQU N GOTO :EOF

ECHO Please ensure modem is on and press any key!
ECHO Step 2 commences....

PAUSE

:: Give option to exit

java -cp D:\proj\bin com.Class

echo Completed program.....

PAUSE