SELECT t.id
FROM t_test t
ORDER BY DECODE(t.id, 3, 'A', 'B') ASC,
         DECODE(t.id, 4, 'A', 'B') ASC,
         DECODE(t.id, 5, 'A', 'B') ASC,
         DECODE(t.id, 6, 'A', 'B') ASC,
         DECODE(t.id, 1, 'A', 'B') ASC,
         DECODE(t.id, 2, 'A', 'B') ASC;