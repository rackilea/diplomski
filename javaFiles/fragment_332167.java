SELECT @newID := MIN(E1.employeeID) + 1
FROM Employee E1
WHERE not exists ( SELECT E2.employeeID 
                   FROM Employee E2
                   WHERE E2.employeeID = E1.employeeID + 1
                 );

INSERT INTO Employee values (@newID, 'name ' + @newID);