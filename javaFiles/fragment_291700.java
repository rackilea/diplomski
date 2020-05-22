@echo off
setlocal

cd /D "%~dp0"

set "CP=."
for /R .\lib %%V in (*.jar) do call :pathmunge "%%V"
call :pathmunge .\resources
call :pathmunge .\conf

start "" javaw.exe -Xmx256m -cp "%CP%" com.topcoder.umltool.deploy.UMLToolDeploy %*

endlocal
goto :EOF

:pathmunge
set "CP=%CP%;%~1"