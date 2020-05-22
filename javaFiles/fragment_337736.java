@ECHO OFF
SET "CODEBASE=C:\project_workspace"
SET "JAVA_HOME=C:\Java\1.7.0.25-x64"
SET "MAVEN_HOME=C:\Maven\Maven3"            

SET "PROJECTA_LOC=%CODEBASE%\ProjectA"
SET "PROJECTB_LOC=%CODEBASE%\ProjectB"

SET MVN_CMD=call mvn clean install -DskipTests -U

REM -- Environment Details --
ECHO CODEBASE: %CODEBASE%
ECHO JAVA_HOME: %JAVA_HOME%
ECHO MAVEN_HOME: %MAVEN_HOME%

REM -- project location  --
ECHO PROJECTA_LOC: %PROJECTA_LOC%
ECHO PROJECTB_LOC: %PROJECTB_LOC%

SET PATH=%PATH%;%JAVA_HOME%/bin;%MAVEN_HOME%/bin;
ECHO %PATH%

REM -- Calling Project A maven build
CD %PROJECTA_LOC% 
%MVN_CMD%

REM -- Calling Project B maven build
CD %PROJECTB_LOC% 
%MVN_CMD%