UPDATE person p
SET    total = d.calc_total
FROM (
  SELECT data_person_id, sum(data_a + data_b + data_c) as calc_total
  FROM   data
  GROUP  BY 1
) d
WHERE  p.person_id = d.data_person_id
AND    p.total IS DISTINCT FROM d.calc_total;