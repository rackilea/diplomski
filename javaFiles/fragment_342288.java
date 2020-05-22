# Build properties
build.dir=build

src.dir=src/main/java
test.src.dir=src/test/java

classes.dir=${build.dir}/classes
test.classes.dir=${build.dir}/test-classes

reports.dir=${build.dir}/reports

# Sonar properties
sonar.projectKey=org.demo:demo
sonar.projectName=Demo project
sonar.projectVersion=1.0
sonar.projectDescription=This is my demo Sonar project

sonar.host.url=http://localhost:9000

sonar.jdbc.url=jdbc:h2:tcp://localhost:9092/sonar
sonar.jdbc.driverClassName=org.h2.Driver
sonar.jdbc.username=sonar
sonar.jdbc.password=sonar

sonar.working.directory=${build.dir}/sonar

sonar.language=java
sonar.sources=${src.dir}
sonar.binaries=${classes.dir}
sonar.tests=${test.src.dir}

sonar.dynamicAnalysis=reuseReports
sonar.surefire.reportsPath=${reports.dir}/junit
sonar.java.coveragePlugin=jacoco
sonar.jacoco.reportPath=${build.dir}/jacoco.exec