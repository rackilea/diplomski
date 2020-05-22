CREATE VIEW [YourEntityOnDB]
AS
SELECT t1.[id], t1.[Att1], t1.[Att2], t2.[Att3], t3.[Att4]
FROM [Table1] t1
JOIN [Table2] t2 ON t1.[id] = t2.[id]
JOIN [Table3] t3 ON t1.[id] = t3.[id]
WHERE t3.[current] = 1;