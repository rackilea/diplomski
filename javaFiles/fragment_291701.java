@echo off
setlocal EnableDelayedExpansion

set "UmlToolDirectory=%~dp0"
cd /D "%UmlToolDirectory%"

set "CP=."
for /R .\lib %%V in (*.jar) do (
    set "LibraryFile=%%V"
    set "LibraryFile=!LibraryFile:%UmlToolDirectory%=.\!"
    call :pathmunge "!LibraryFile!"
)
call :pathmunge .\resources
call :pathmunge .\conf

start "" javaw.exe -Xmx256m -cp "%CP%" com.topcoder.umltool.deploy.UMLToolDeploy %*

endlocal
goto :EOF

:pathmunge
set "CP=%CP%;%~1"