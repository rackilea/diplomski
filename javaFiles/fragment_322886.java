1. Download and install Java JDK (minimum 1.7) Jave SE downloads

2. Download Maven Binary from Apache from the Maven Downloads Page or use this direct link for Maven 3.2.1 (Binary zip)

3. Extract zip file to C:\Program Files (x86)\ApacheMaven\apache-maven-3.2.1 (Note: if you select a different directory, please update following steps accordingly)

4. Open the “Environment Variables” in Windows. (WinKey + Pause/Break) > Advanced System Settings > Advanced tab > “Environment Variables…” Button.

5. Add the following variables to the “System variables” section. (Not the “User variables”)

JAVA_HOME
C:\Program Files\Java\jdk1.7.0_51

M2_HOME
C:\Program Files (x86)\ApacheMaven\apache-maven-3.2.1

M2
%M2_HOME%\bin

6. Open the “Path” variable in the System variables section, and add the following at the end of your Path:
;%M2%;%JAVA_HOME%\bin
Note: the semicolon ( ; ) is used to separate values.

7. Open a new command prompt (Winkey + R then type cmd) and run mvn --version

to verify that it is correctly installed.

C:\Users\curtis>mvn --version
Apache Maven 3.2.1 (ea8b2b07643dbb1b84b6d16e1f08391b666bc1e9; 2014-02-14T10:37:52-07:00)
Maven home: C:\Program Files (x86)\ApacheMaven\apache-maven-3.2.1
Java version: 1.7.0_51, vendor: Oracle Corporation
Java home: C:\Program Files\Java\jdk1.7.0_51\jre
Default locale: en_US, platform encoding: Cp1252
OS name: "windows 7", version: "6.1", arch: "amd64", family: "windows"