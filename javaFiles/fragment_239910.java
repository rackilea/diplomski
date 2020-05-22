CREATE OR REPLACE FUNCTION my_fun( ord VARCHAR2 )
RETURN sys_refcursor
IS
   refcur SYS_REFCURSOR;
BEGIN
    OPEN refcur FOR 
        'SELECT level as x, 100-level as y  FROM dual
        CONNECT BY LEVEL <= 10
        ORDER BY ' || ord;
    RETURN refcur;
END;
/