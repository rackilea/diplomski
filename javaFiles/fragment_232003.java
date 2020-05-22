-- Create table "test" and insert 2,000,000 integers from 1 up to 2,000,000.
WITH RECURSIVE t(n) AS
(
  VALUES (1)
  UNION ALL
  SELECT n+1
  FROM t
  WHERE n < 2000000
)
SELECT n as value
INTO test
FROM t;