Initializing jdb ...
> stop in TestClass.main
Deferring breakpoint TestClass.main.
It will be set after the class is loaded.
> run TestClass
run  TestClass
Set uncaught java.lang.Throwable
Set deferred uncaught java.lang.Throwable
>
VM Started: Set deferred breakpoint TestClass.main

Breakpoint hit: "thread=main", TestClass.main(), line=17 bci=0
17        GETSTATIC java/lang/System.out : Ljava/io/PrintStream;

main[1] locals
Method arguments:
arg = instance of java.lang.String[0] (id=433)
Local variables:
main[1] step
>
Step completed: "thread=main", TestClass.main(), line=18 bci=3
18        LDC "hello world"

main[1] step
>
Step completed: "thread=main", TestClass.main(), line=19 bci=5
19        INVOKEVIRTUAL java/io/PrintStream.println (Ljava/lang/String;)V

main[1] step
> hello world

Step completed: "thread=main", TestClass.main(), line=20 bci=8
20        RETURN

main[1] step
>
The application exited