create or replace FUNCTION HelloWorldExample
(
  p_Input1 VARCHAR2,
  p_Input2 VARCHAR2,
  p_Input3 VARCHAR2
)
   RETURN CLOB
   AS LANGUAGE JAVA
   NAME 'OuterClass.WriteIt(java.lang.String,java.lang.String,java.lang.String) 
   return java.lang.String';