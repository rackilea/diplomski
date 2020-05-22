cd D:\test;
"JAVA_HOME=C:\\Program Files\\Java\\jdk1.8.0_112" 
"M2_HOME=C:\\Program Files\\apache-maven-3.3.3"
cmd /c "\"\"C:\\Program Files\\apache-maven-3.3.3\\bin\\mvn.cmd\"
    -Dexec.args=\"-classpath %classpath com.test.AppStarter\"
    -Dexec.executable=\"C:\\Program Files\\Java\\jdk1.8.0_112\\bin\\java.exe\"
    -Dexec.workingdir=D:\\test\\target\\dist
    -Dmaven.ext.class.path=\"C:\\Program Files\\NetBeans 8.2\\java\\maven-nblib\\netbeans-eventspy.jar\"
    -Dfile.encoding=UTF-8
    org.codehaus.mojo:exec-maven-plugin:1.2.1:exec\""