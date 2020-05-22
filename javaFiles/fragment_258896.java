SET myDatabase; 

DROP PROCEDURE IF EXISTS myStoredProcedure; 

CREATE PROCEDURE myStoredProcedure ( _description VARCHAR(50), _value INT ) 

BEGIN 

INSERT INTO 
    myTable ( description, value ) 
VALUES ( _description, _value ); 

SELECT id, description, value 
  FROM myTable 
WHERE id = LAST_INSERT_ID(); 

END;