@Deprecated /* >nul 2>&1


:: requires ran javaExtInstaller.bat
:: https://github.com/npocmaka/batch.scripts/blob/master/Java/javaExtInstaller.bat
:: 
:: self compiled java/.bat hybrid
::
:: deprecated is the only one annotation that can be used outside the class definition
:: and is needed for 'mute' start of multi-line java comment
:: that will be not printed by the batch file.
:: allows you to embed both batch and java code into one file

@echo off

setlocal
java -version >nul 2>&1 || (
    echo java not found
    exit /b 1
)


if not exist "%~n1.class" javac "%~nx1" 

:: to compile the class every time use:
:: javac "%~nx1" 

java "%~n1"


endlocal
exit /b 0

*******/



public class TestClass
{
    public static void main(String args[])
    {
       System.out.println("selfcompiled .bat/.java hybrid");
    }
}