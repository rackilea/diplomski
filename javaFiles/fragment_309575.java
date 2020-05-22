create or replace FUNCTION HelloWorldExample
(
  p_Input1 CLOB,
  p_Input2 VARCHAR2,
  p_Input3 VARCHAR2
)
   RETURN CLOB
   AS LANGUAGE JAVA
   NAME 'OuterClass.WriteIt(java.sql.Clob,java.lang.String,java.lang.String) 
   return java.lang.String';