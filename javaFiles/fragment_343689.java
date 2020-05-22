SELECT *
FROM (
  SELECT *
  FROM   application_details
  ORDER BY total_marks DESC, subject_marks DESC
  )
WHERE ROWNUM <= 30;