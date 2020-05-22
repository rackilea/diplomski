WITH RECURSIVE m AS (
  SELECT 
    id, 
    ARRAY[seq] AS path, 
    name, 1 AS level, 
    '- ' || name AS display
  FROM menu
  WHERE pid IS NULL
  UNION ALL 
  SELECT 
    menu.id, 
    path || seq, 
    menu.name, 
    m.level + 1 AS level, 
    repeat('  ', m.level) || '- ' || menu.name
  FROM menu JOIN m ON m.id = menu.pid
)
SELECT *
FROM m
ORDER BY path;