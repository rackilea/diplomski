#Create the meta file (after javac)
cobertura-instrument.bat [--basedir dir] [--datafile file] [--auxClasspath classPath] [--destination dir] [--ignore regex] classes [...]

#Execution should include this extra jar in cp:
#Example
java -cp C:\cobertura\lib\cobertura.jar;C:\MyProject\build\instrumented;C:\MyProject\build\classes;C:\MyProject\build\test-classes -Dnet.sourceforge.cobertura.datafile=C:\MyProject\build\cobertura.ser ASimpleTestCase

#Publish the report
cobertura-report.bat --format xml --datafile C:\MyProject\build\cobertura.ser --destination C:\MyProject\reports\coverage C:\MyProject\src