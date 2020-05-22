CREATE OR REPLACE FUNCTION ADMIN.GETDATA(IN_1 IN VARCHAR2, 
                                   IN_2 IN VARCHAR2, 
                                   IN_3 IN VARCHAR2, 
                                   OUT_1 IN OUT VARCHAR2) RETURN INTEGER
IS
BEGIN
    OUT_1 := IN_1 || IN_2 || IN_3;
    RETURN 5;
END;