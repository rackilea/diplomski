c:\Users\Jon\Test>javac -source 1.7 BooleanTest.java

(No console output, i.e. no errors)

c:\Users\Jon\Test>javac -source 1.6 BooleanTest.java
warning: [options] bootstrap class path not set in conjunction with -source 1.6
BooleanTest.java:10: error: inconvertible types
        boolean bool = (boolean) objarray[1];
                                         ^
  required: boolean
  found:    Object
1 error
1 warning