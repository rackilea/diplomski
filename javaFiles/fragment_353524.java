DELETE FROM table_name
WHERE column_name NOT IN (
SELECT column_name 
FROM table_name 
ORDER BY column_name DESC
LIMIT 10);