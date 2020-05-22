WITH link(id, data, reference, sort_val, level, tree_id) AS (
    -- Each tree root starts with a random sorting value up to half the number of records.
    -- This half the number of records is not really needed it can be a hard coded value
    -- I just said half to achieve a relative uniform distribution of three ids
    -- take the id of the starting row as a three id
    SELECT id, data, reference, round(rand()*(select count(*) FROM test)/2) AS sort_val, 0, id FROM test WHERE reference IS NULL

    UNION ALL

    -- Increase the sort value by level for each referencing row
    SELECT test.id, test.data, test.reference, link.sort_val + (level + 1) AS sort_val, level + 1, link.tree_id
       FROM link
       JOIN test ON link.id = test.reference
)
-- sort value, level and tree id are printed here just to make it easier to understand how it works
SELECT id, data, reference, sort_val, level, tree_id
  FROM link
 ORDER BY sort_val;