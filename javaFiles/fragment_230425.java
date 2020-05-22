SELECT
    v1.sop,
    FUNC('DATE_TRUNC', 'day', v1.scrappedAt) AS dt,
    (SELECT SUM(totalValue) FROM TABLE v2
     WHERE v2.sop = v1.sop AND
         FUNC('DATE_TRUNC', 'day', v2.scrappedAt) =
         FUNC('DATE_TRUNC', 'day', v1.scrappedAt) AND
         v2.acoordStatus LIKE 'done%' AND
         (:plant is null OR v2.target = :plant) AND
         v2.scrappedAt IS NOT NULL) value_sum
FROM TABLE v1
WHERE
    v1.coordStatus LIKE 'done%' AND
    (:plant is null OR v1.target = :plant) AND
    v1.scrappedAt IS NOT NULL;