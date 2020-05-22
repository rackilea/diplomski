efrisch@eeyore ~ $ jshell
|  Welcome to JShell -- Version 9-ea
|  For an introduction type: /help intro


jshell> /help intro
|  
|  intro
|  
|  The jshell tool allows you to execute Java code, getting immediate results.
|  You can enter a Java definition (variable, method, class, etc), like:  int x = 8
|  or a Java expression, like:  x + x
|  or a Java statement or import.
|  These little chunks of Java code are called 'snippets'.
|  
|  There are also jshell commands that allow you to understand and
|  control what you are doing, like:  /list
|  
|  For a list of commands: /help

jshell> for (int i = 0; i < 4; i++) {
   ...> System.out.println(i);
   ...> }

0
1
2
3