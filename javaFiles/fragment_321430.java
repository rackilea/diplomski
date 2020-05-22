CREATE OR REPLACE TYPE dbObject AS OBJECT
    (
       empId NUMBER (6),// here add as many fields you want to return or want your object to have
       emailId VARCHAR2 (25),
       hiredate DATE
    );
CREATE OR REPLACE TYPE datalist IS TABLE OF DBOBJECT;

PROCEDURE get_emp_data (list OUT datalist)
   AS
      CURSOR emp_cursor
      IS
         SELECT employee_id AS empId,
                EMPLOYEES.EMAIL AS emailId,
                EMPLOYEES.HIRE_DATE AS hiring
           FROM EMPLOYEES;
           c_datatype emp_cursor%rowtype;

   BEGIN
  OPEN emp_cursor();
      list := datalist();
      LOOP
        fetch emp_cursor into c_datatype;
         EXIT WHEN emp_cursor%NOTFOUND;
         list.extend;
         list(emp_cursor%ROWCOUNT):=DBOBJECT(c_datatype.empId,c_datatype.emailId,c_datatype.hiring);         
      END LOOP;
   END get_emp_data;