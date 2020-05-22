CREATE OR REPLACE FUNCTION myMethod( p_arg1 IN NUMBER,
                                     p_arg2 IN NUMBER ) 
  RETURN VARCHAR2 
AS
  LANGUAGE JAVA NAME 
    'MyJavaClass.MyMethod (java.lang.Integer, java.lang.Integer) 
          return java.lang.String';