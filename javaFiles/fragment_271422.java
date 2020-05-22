$ javac Test.java && jdb Test
Initializing jdb ...
> stop in Test.listToMap
Deferring breakpoint Test.listToMap.
It will be set after the class is loaded.
> run
run Test
Set uncaught java.lang.Throwable
Set deferred uncaught java.lang.Throwable
>
VM Started: Set deferred breakpoint Test.listToMap

Breakpoint hit: "thread=main", Test.listToMap(), line=14 bci=0
14            return objs.stream().collect(Collectors.toMap(Object::hashCode, obj -> obj));

main[1]