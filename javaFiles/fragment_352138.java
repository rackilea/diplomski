SELECT A.documentID, 
CONCAT_WS(' ', B.firstName, B.lastName) AS userID, 
CONCAT_WS(' ', B.firstName, B.lastName) AS modifiedUser  
FROM document  A, USER B 
WHERE B.userID = A.userID 
ORDER BY A.documentID;