DROP TRIGGER IF EXISTS Persons_log_update ^; 

CREATE TRIGGER Persons_log_update 
    BEFORE UPDATE ON Persons
    FOR EACH ROW 
BEGIN

    INSERT INTO Personshistory(PersonID,LastName,FirstName,Address,City)
    values(OLD.PersonID,OLD.LastName,OLD.FirstName,OLD.Address,OLD.City);

END ^;