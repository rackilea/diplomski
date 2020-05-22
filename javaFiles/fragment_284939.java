SQL> CREATE OR REPLACE TYPE typ IS TABLE OF NUMBER;
  2  /

Type created.

SQL> CREATE OR REPLACE FUNCTION f RETURN typ PIPELINED IS
  2  BEGIN
  3     PIPE ROW (1);
  4     RETURN;
  5  END;
  6  /

Function created.

SQL> DECLARE
  2     l typ;
  3  BEGIN
  4     l := f;
  5  END;
  6  /
   l typ;
 *
ERROR at line 2:
ORA-06550: line 1, column 10:
PLS-00653: aggregate/table functions are not allowed in PL/SQL scope