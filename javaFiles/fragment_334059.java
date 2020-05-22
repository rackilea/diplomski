SET @cols = NULL;
SET @sql = NULL;

SELECT
  GROUP_CONCAT(DISTINCT CONCAT('MAX(IF(Name = ''',
      Name, ''', Amount , NULL)) AS ', '''', Name , '''')
  ) INTO @cols
FROM table1;


SET @sql = CONCAT('SELECT 
  Date, ', @cols , ', SUM(Amount) AS Total 
FROM table1
GROUP BY Date;');

prepare stmt 
FROM @sql;

execute stmt;