SELECT DISTINCT *  -- you probably don't need DISTINCT
FROM   A
WHERE  Id = 'A'
AND    EventType = 'Start'
AND    NOT EXISTS (
    SELECT 1
    FROM   A a1
    WHERE  a1.Id = A.Id
    AND    EventType = 'endEvent'
    );