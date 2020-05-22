SET @rn = 0;

SELECT 
    (@rn:=@rn + 1) AS rn, name
FROM yourTable;
ORDER BY id;