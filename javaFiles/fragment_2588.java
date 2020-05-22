PS H:\> where.exe java
C:\JDK\1.6.0.31\bin\java.exe
C:\JDK64\1.8.0.45\bin\java.exe
C:\JDK64\1.6.0.31.1\bin\java.exe
C:\JDK64\1.7.0.79\bin\java.exe
C:\Windows\System32\java.exe
PS H:\> where.exe java | %{$_ -replace "[a-zA-Z0-9]+\.exe", ""}
C:\JDK\1.6.0.31\bin\
C:\JDK64\1.8.0.45\bin\
C:\JDK64\1.6.0.31.1\bin\
C:\JDK64\1.7.0.79\bin\
C:\Windows\System32\
PS H:\>