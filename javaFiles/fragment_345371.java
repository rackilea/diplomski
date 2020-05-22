$ rm *.class
$ cat Beach.java
public class Beach {
    private String name, city;

    public Beach(String name, String city) {
        this.name = name;
        this.city = city;
    }
}
$ javac Beach.java
$ javap Beach
Compiled from "Beach.java"
public class Beach {
  public Beach(java.lang.String, java.lang.String);
}
$ jython
Jython 2.7b1 (default:ac42d59644e9, Feb 9 2013, 15:24:52)
[Java HotSpot(TM) 64-Bit Server VM (Oracle Corporation)] on java1.7.0_15
Type "help", "copyright", "credits" or "license" for more information.
>>> import Beach
>>> b = Beach()
Traceback (most recent call last):
  File "<stdin>", line 1, in <module>
TypeError: Beach(): expected 2 args; got 0
>>>