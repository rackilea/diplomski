SELECT
    hash_id, COLLECT_LIST(num_of_cats) AS aggr_set
FROM
    tablename
WHERE
    blablabla
GROUP BY
    hash_id
;