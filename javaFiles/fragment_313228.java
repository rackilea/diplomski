@echo off

set SRC_PATH=C:\Users\Alexander\Documents\java-src
set ASPECTJ_HOME=C:\Program Files\Java\AspectJ

echo Building annotation processor
cd "%SRC_PATH%\SO_AJ_APT_MoveAnnotationsFromMemberToGetter"
rmdir /s /q bin
del /q processor.jar
call "%ASPECTJ_HOME%\bin\ajc.bat" -1.8 -sourceroots src_apt -d bin -cp "%ASPECTJ_HOME%\lib\aspectjrt.jar"
jar -cvf processor.jar -C src_apt META-INF -C bin .

echo.
echo Generating aspects and building project
rmdir /s /q bin .apt_generated
call "%ASPECTJ_HOME%\bin\ajc.bat" -1.8 -sourceroots src -d bin -s .apt_generated -inpath processor.jar -cp "%ASPECTJ_HOME%\lib\aspectjrt.jar";processor.jar -showWeaveInfo

echo.
echo Running de.scrum_master.app.Person
java -cp bin;"%ASPECTJ_HOME%\lib\aspectjrt.jar" de.scrum_master.app.Person