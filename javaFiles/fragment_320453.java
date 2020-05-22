SELECT a 
FROM Audit a 
WHERE loginDate=(
SELECT MAX(loginDate) 
FROM Audit 
WHERE user = a.user);