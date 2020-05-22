rem Reads the content of the Java source from InternalT2Driver.java 
rem then compiles it 
connect hr/hr
CREATE OR REPLACE AND COMPILE JAVA SOURCE NAMED InternalT2Driver_src AS
@ InternalT2Driver.java
/

show error

rem A wrapper (a.k.a. Call Spec), to invoke Java
rem function in the database from SQL, PL/SQL, and client applications
CREATE OR REPLACE PROCEDURE InternalT2Driver_proc AS 
LANGUAGE JAVA NAME 'InternalT2Driver.jrun ()';
/

rem Running the sample
connect hr/hr
SET SERVEROUTPUT ON SIZE 10000 
CALL dbms_java.set_output (10000);

execute InternalT2Driver_proc;