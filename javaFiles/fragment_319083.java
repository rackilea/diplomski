`@echo off
set JRE_HOME="C:\Program Files\Java\jre6"
echo %JRE_HOME%
set ARG=%ARG% -Xbootclasspath/a:%JRE_HOME%\lib\javaws.jar;%JRE_HOME%\lib\deploy.jar
set ARG=%ARG% -classpath %JRE_HOME%\lib\deploy.jar
set ARG=%ARG% -Djnlpx.home=%JRE_HOME%\bin 
set ARG=%ARG% -Djnlpx.slashport=1322
set ARG=%ARG% -Djnlpx.jvm=%JRE_HOME%\bin\javaw.exe
set ARG=%ARG% -Djnlpx.remove=false
echo %ARG%                     
%JRE_HOME%\bin\javaw.exe %ARG% com.sun.javaws.Main "PRC_ApplicationInstruction1.6.jnlp"`