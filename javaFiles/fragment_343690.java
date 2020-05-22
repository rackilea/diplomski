SELECT *
FROM   (
  SELECT DENSE_RANK()
         OVER (ORDER BY total_marks DESC,
                        subject_marks DESC) dr,
         ad.*
  FROM   application_details ad
  )
WHERE dr <= 30;