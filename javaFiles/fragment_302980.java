@echo off
setlocal EnableExtensions DisableDelayedExpansion
set "SourceFolder=%~dp0"
set "SourceFolder=%SourceFolder:~0,-1%"
set "CommentFile=%SourceFolder%\Setup.txt"
for %%I in ("%SourceFolder%") do set "ArchiveFile=%%~dpIsongkong-windows64.exe"

if not exist "%CommentFile%" (
    echo ;The comment below contains SFX script commands
    echo/
    echo Setup=JVM64\bin\javaw.exe -jar install.jar
    echo TempMode
    echo Title=Unpacking SongKong Installer
)>"%CommentFile%"

del "%ArchiveFile%" 2>nul

rem Create solid RAR5 SFX archive using best compression with 64 MB dictionary size.
echo Create RAR SFX, please wait ...
"%ProgramFiles%\WinRAR\WinRar.exe" a -@ -afrar -cfg- -ep1 -ibck -iicon"%SourceFolder%\setup.ico" -k -m5 -ma5 -md64m -r -s -sfx"%ProgramFiles%\WinRAR\SfxModule\Default64.sfx" -x"%SourceFolder%\Setup.*" -x"%~f0" -tl -y -z"%CommentFile%" -- "%ArchiveFile%" "%SourceFolder%\"

rem Create ZIP SFX archive using best compression.
rem echo Create ZIP SFX, please wait ...
rem "%ProgramFiles%\WinRAR\WinRar.exe" a -@ -afzip -cfg- -ep1 -ibck -iicon"%SourceFolder%\setup.ico" -m5 -r -sfx"%ProgramFiles%\WinRAR\Zip64.sfx" -x"%SourceFolder%\Setup.*" -x"%~f0" -tl -y -z"%CommentFile%" -- "%ArchiveFile%" "%SourceFolder%\"
endlocal