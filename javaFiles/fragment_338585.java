set ANT_HOME=C:\ant197
set ANT_ARGS=-lib C:\antxtralibs
set JAVA_HOME=C:\jdk180_121
set PATH=%JAVA_HOME%\bin;%ANT_HOME%\bin;%PATH%

:: default
ant -f %1

:: debug
:: ant -debug -f %1