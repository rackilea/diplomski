SELECT s.*
     , h.value height
     , w.value weight
  FROM student s
  LEFT 
  JOIN student_skill h
    ON h.id_student = s.id
   AND h.skill = 'height'
  LEFT
  JOIN student_skill w
    ON w.id_student = s.id
   AND w.skill = 'weight';

+----+-------+--------+--------+
| id | name  | height | weight |
+----+-------+--------+--------+
|  1 | Peter |    180 |     75 |
|  2 | David |    170 |   NULL |
|  3 | Mark  |    180 |   NULL |
|  4 | Peter |    170 |     75 |
|  5 | Brian |    180 |     75 |
+----+-------+--------+--------+