SELECT DISTINCT *  -- you probably don't need DISTINCT
FROM   A
LEFT   JOIN A a1 ON a1.Id = A.Id
                AND a1.EventType = 'endEvent'
WHERE  A.Id = 'A'
AND    A.EventType = 'Start'
AND    a1.Id IS NULL;