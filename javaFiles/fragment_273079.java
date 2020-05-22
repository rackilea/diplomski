- Start Command Prompt.

 - Navigate to the folder that holds your class files:

    C:\>cd \mywork

 - Set path to include JDK’s bin.  For example:

    C:\mywork> path c:\Program Files\Java\jdk1.7.0_25\bin;%path%

 - Compile your class(es):

    C:\mywork> javac *.java

 - Create a manifest file

   manifest.txt with, for example, this content:

        Manifest-Version: 1.0
        Created-By: 1.8.0_171 (Oracle Corporation) #your jdk version
        Main-Class: mainPackage.MainClass

 - Create the jar file:

    C:\mywork> jar cvfm Craps.jar manifest.txt *.class