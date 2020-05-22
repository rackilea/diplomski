REG ADD "HKEY_CLASSES_ROOT\*\shell\File Marker" ^
/v "MUIVerb" /t REG_SZ /d "File Marker" /f

REG ADD "HKEY_CLASSES_ROOT\*\shell\File Marker" ^
/v "SubCommands" /t REG_EXPAND_SZ /d "WinIconChanger.PLANNED_WORK;WinIconChanger.HALF-DONE_WORK;WinIconChanger.DONE_WORK" /f

REG ADD "HKEY_LOCAL_MACHINE\Software\Microsoft\Windows\CurrentVersion\Explorer\CommandStore\shell\WinIconChanger.PLANNED_WORK" ^
/v "MUIVerb" /t REG_SZ /d "Planned work" /f
REG ADD "HKEY_LOCAL_MACHINE\Software\Microsoft\Windows\CurrentVersion\Explorer\CommandStore\shell\WinIconChanger.PLANNED_WORK\command" ^
/ve /t REG_SZ /d "\"C:\path\to\jre\bin\javaw.exe\" -jar \"C:\path\to\WinIconChanger.jar\" \"PLANNED_WORK\" \"%%1\"" /f

REG ADD "HKEY_LOCAL_MACHINE\Software\Microsoft\Windows\CurrentVersion\Explorer\CommandStore\shell\WinIconChanger.HALF-DONE_WORK" ^
/v "MUIVerb" /t REG_SZ /d "Half-done work" /f
REG ADD "HKEY_LOCAL_MACHINE\Software\Microsoft\Windows\CurrentVersion\Explorer\CommandStore\shell\WinIconChanger.HALF-DONE_WORK\command" ^
/ve /t REG_SZ /d "\"C:\path\to\jre\bin\javaw.exe\" -jar \"C:\path\to\WinIconChanger.jar\" \"HALF-DONE_WORK\" \"%%1\"" /f

REG ADD "HKEY_LOCAL_MACHINE\Software\Microsoft\Windows\CurrentVersion\Explorer\CommandStore\shell\WinIconChanger.DONE_WORK" ^
/v "MUIVerb" /t REG_SZ /d "Done work" /f
REG ADD "HKEY_LOCAL_MACHINE\Software\Microsoft\Windows\CurrentVersion\Explorer\CommandStore\shell\WinIconChanger.DONE_WORK\command" ^
/ve /t REG_SZ /d "\"C:\path\to\jre\bin\javaw.exe\" -jar \"C:\path\to\WinIconChanger.jar\" \"DONE_WORK\" \"%%1\"" /f

PAUSE