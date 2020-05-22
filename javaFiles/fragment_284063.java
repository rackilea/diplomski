"SELECT DATE(D) AS temporary_date, SUM(IFNULL(quantity,0)) AS total_amount, DATE(date) AS created_date "+ 
"FROM "+ 
   "( SELECT DATE_SUB(NOW(), INTERVAL D DAY) AS D "+ 
    " FROM (SELECT 0 as D "+ 
              "UNION SELECT 1 "+ 
              "UNION SELECT 2 "+ 
              "UNION SELECT 3 "+ 
              "UNION SELECT 4 "+ 
              "UNION SELECT 5 "+ 
              "UNION SELECT 6 ) AS D ) AS D "+ 
"LEFT JOIN milk_collection ON DATE(date) = date(D) "+ 
"GROUP BY temporary_date ORDER BY D ASC ";