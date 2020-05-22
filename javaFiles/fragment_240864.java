SELECT name,sum(total)
FROM   table s
WHERE 
        (
            SELECT  COUNT(*) 
            FROM    table t
            WHERE t.name = s.name AND 
                  t.number >= s.number
        ) <= 2
 group by name;