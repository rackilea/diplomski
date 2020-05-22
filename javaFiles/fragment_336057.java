@echo off

rem change to this batch's folder
pushd "%~dp0"

set Path="%~dp0\Java\bin";%%Path%%
set JAVA_HOME=%~dp0\Java
java -jar App.jar

popd