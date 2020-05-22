SELECT userdetails.*
FROM userdetails
JOIN (SELECT usertype,
             MAX(userID) AS highestIDperType
      FROM userdetails
      GROUP BY usertype
     ) USING (usertype)
ORDER BY highestIDperType DESC,
         userID DESC;