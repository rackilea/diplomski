CREATE OR REPLACE FUNCTION func1(...)
  RETURN SYS_REFCURSOR
  AS
    foo SYS_REFCURSOR;
  BEGIN
    proc1(..., foo);
    RETURN foo;
  END func1;
/