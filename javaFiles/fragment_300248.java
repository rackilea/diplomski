SELECT *
FROM Person p
WHERE (
  CASE (
    SELECT COUNT(*)
    FROM Person p2
    WHERE p2.firstname = :firstname AND p2.lastname = :lastname
     ) 
  WHEN 0 THEN 
    p.lastname = :lastname 
  ELSE 
    p.firstname = :firstname AND p.lastname = :lastname 
  END
);