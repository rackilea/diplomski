SQL> CREATE OR REPLACE AND COMPILE JAVA SOURCE NAMED "Roman" AS
  2  class Roman {
  3     public static int getArabo(java.lang.String x){
  4          return 0;
  5      }
  6  }
  7  /

Java created

SQL> CREATE OR REPLACE FUNCTION converti (alfa IN varchar2)
  2     RETURN NUMBER
  3  AS LANGUAGE JAVA NAME 'Roman.getArabo(java.lang.String) return int';
  4  /

Function created

SQL> select converti ('aaa') from dual;

CONVERTI('AAA')
---------------
              0