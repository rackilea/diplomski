BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE emp';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;
/
create table emp
 (
    name varchar2(30), email varchar2(40),
    pass varchar2(30), count varchar2(30),
    state varchar2(30), phone number(15)
 );