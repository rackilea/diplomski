CREATE OR REPLACE PROCEDURE updatestudentresult(id INT) AS

BEGIN
  UPDATE students
     SET total = mark1+mark2+mark3,
     average = (mark1+mark2+mark3)/3,
     grd = CASE
           WHEN (mark1+mark2+mark3)/3 > 85 THEN 'A'
           WHEN (mark1+mark2+mark3)/3 > 65 THEN 'B'
           WHEN (mark1+mark2+mark3)/3 > 50 THEN 'C'
           ELSE 'D'
           END
   WHERE sid = id;
END;