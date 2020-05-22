SELECT
  Date,
  SUM(CASE WHEN Name = 'John' THEN Amount ELSE 0 END) AS 'John', 
  SUM(CASE WHEN Name = 'James' THEN Amount ELSE 0 END) AS 'James', 
  SUM(CASE WHEN Name = 'Thomas' THEN Amount ELSE 0 END) AS 'Thomas',
  SUM(Amount) AS Total
FROM tablename
GROUP BY Date;