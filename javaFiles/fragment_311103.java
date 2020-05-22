@ECHO Off
SETLOCAL
SET "tempfilename=%temp%\temp###.###"
(CALL :getpath)>"%tempfilename%"
FOR /f "usebackqdelims=" %%a IN ("%tempfilename%") DO (
 IF NOT EXIST "%%~a\." (ECHO "%%~a" IN PATH but missing) ELSE (
  FOR %%b IN (java.exe java.dll) DO IF EXIST "%%~a\%%b" (
   FOR %%c IN ("%%~a\%%b") DO (ECHO %%~c IN PATH dated %%~tc %%~zc bytes)
  )
 )
)
DEL "%tempfilename%" 2>nul
GOTO :EOF

:getpath
ECHO .
ECHO %path:;=&ECHO(%
GOTO :EOF