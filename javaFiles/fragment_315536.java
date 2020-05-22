SELECT periodOfDay, COUNT(*),
       SUM(CASE WHEN range_1 < 36 AND range_2 < 18 THEN 1 ELSE 0 END),
       SUM(CASE WHEN range_1 > 36 AND range_1 < 100 AND range_2 > 18 AND range_2 < 100 THEN 1 ELSE 0 END),
       SUM(CASE WHEN range_1 > 100 AND range_2 > 100 THEN 1 ELSE 0 END)
FROM tb_journal
GROUP BY periodOfDay;