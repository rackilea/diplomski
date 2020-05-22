1: CREATE OR REPLACE PROCEDURE Proc
   AS
        b NUMBER:=3
2: 
        c VARCHAR2(2000)
3: 
    begin
        c := 'BEGIN ' || ' :1 := :1 + :2; ' || 'END;'
4: 
   end Proc