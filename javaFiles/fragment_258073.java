SELECT AVG( middle_values ) AS 'median'
FROM (

SELECT t1.`vol` AS 'middle_values'
FROM (

SELECT @row := @row +1 AS `row` , x.`vol` 
FROM (

SELECT * 
FROM EOD_PRICING
WHERE `ticker` =16665396
ORDER BY `xdate` DESC 
LIMIT 22
) AS x, (

SELECT @row :=0
) AS r
ORDER BY x.`vol`
) AS t1, (

SELECT COUNT( * ) AS 'count'
FROM (

SELECT * 
FROM EOD_PRICING
WHERE `ticker` =16665396
ORDER BY `xdate` DESC 
LIMIT 22
) AS x
) AS t2
WHERE t1.row >= t2.count /2
AND t1.row <= ( (
t2.count /2
) +1 )
) AS t3;