SELECT x.*
     , y.height
     , y.weight 
  FROM student x 
  JOIN 
     ( SELECT id_student
            , MAX(CASE WHEN skill = 'height' THEN value END) height
            , MAX(CASE WHEN skill = 'weight' THEN value END) weight 
         FROM student_skill 
        GROUP 
           BY id_student
     ) y
    ON y.id_student = x.id;
+----+-------+--------+--------+
| id | name  | height | weight |
+----+-------+--------+--------+
|  1 | Peter |    180 |     75 |
|  2 | David |    170 |   NULL |
|  3 | Mark  |    180 |   NULL |
|  4 | Peter |    170 |     75 |
|  5 | Brian |    180 |     75 |
+----+-------+--------+--------+