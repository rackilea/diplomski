set DIR=path\to\dir\containing\selenium\and\stuff
cd "%DIR%" && java -cp "%DIR%;%DIR%\output;%DIR%\bin\selenium-server-standalone-2.33.0.jar" ^
-Dwebdriver.chrome.driver="%DIR%\bin\chromedriver.exe" ^
-Dwebdriver.chrome.args="--disable-logging" ^
-Dwebdriver.chrome.logfile=NUL ^
AllTests