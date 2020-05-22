ext {
   libs = "${rootProject.projectDir}/libs"
   testLibs = "${rootProject.projectDir}/test.libs"
}
dependencies {
   compile files("${libs}/activation.jar", "${libs}/imap.jar")
   compile files("${testLibs}/gson-2.2.4.jar")
   ...
}