c:\Users\Jon\Test>javac -Xlint SneakyThrow.java
SneakyThrow.java:9: warning: [unchecked] unchecked cast
    throw (T) ex;
              ^
  required: T
  found:    Throwable
  where T is a type-variable:
    T extends Throwable declared in method <T>sneakyThrowInner(Throwable)
1 warning