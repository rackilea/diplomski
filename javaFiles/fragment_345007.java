PREPARE test1 AS
SELECT count(*) AS ct
     , date_part('day', $1 - c.lastseen) AS difference
FROM   myobject c 
GROUP  BY date_part('day', $1 - c.lastseen)
ORDER  BY difference;