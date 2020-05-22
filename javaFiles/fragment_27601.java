String linuxCommand[] = {"/opt/jdk/jdk1.6.0_22/bin/java",
                         "-classpath",
                         "/var/xp/client/a/h/n/clases/z1:/var/xp/client/a/h/n/test",
                         "MyObjectT",
                         "/m:Param21",
                         "/f:/var/xp/client/a/h/n/IOFile/1_Input.txt",
                         "/o:/var/xp/client/a/h/n/IOFile/1_Output.txt"};
Process p = Runtime.getRuntime().exec(linuxCommand);