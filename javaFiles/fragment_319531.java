CREATE OR REPLACE PROCEDURE  INSERT_NEW_CAT (age age, weight weight, name name)  
AS
BEGIN  
    forall i in 1..age.last  
        insert into cats(id,age,weight,name)  
        vales(cat_sequence.nextval,age(i),weight(i),name(i);  
END INSERT_NEW_CAT;