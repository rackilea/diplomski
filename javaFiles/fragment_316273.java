set @row_limit = 3;
set @row_num = 0;
set @code = -1;

SELECT a.sfcode, COALESCE((b.QTY - COALESCE(c.QTY,0)),0) AS currentstock, 
a.lastprice AS lprice, COALESCE(CAST(d.price AS decimal(16,3)),0) AS sprice,
COALESCE(CAST(e.price AS decimal(16,3)),0) AS cprice FROM 
(SELECT sfcode, lastprice FROM products) AS a LEFT JOIN
(SELECT sfcode, SUM(COALESCE(QTY, 0)) AS QTY 
    FROM transactions 
    WHERE doctype IN ('FP','LP','CSR') 
    GROUP BY sfcode) AS b ON a.sfcode = b.sfcode LEFT JOIN
(SELECT sfcode, SUM(QTY) AS QTY 
    FROM transactions 
    WHERE doctype IN ('FPR','LPR','CAS','CRS') 
GROUP BY sfcode) AS c ON a.sfcode = c.sfcode LEFT JOIN 
(SELECT sfcode, AVG(unitprice) AS price 
FROM (SELECT sfcode, unitprice, 
    @row_num := if(@code = sfcode, @row_num + 1, 0) AS rowNumber, 
    @code := sfcode AS code 
    FROM transactions 
    WHERE doctype IN ('CAS', 'CRS') 
    ORDER BY sfcode, docdate DESC) AS f 
WHERE f.rowNumber < @row_limit GROUP BY sfcode) 
AS d ON a.sfcode = d.sfcode 
LEFT JOIN (SELECT sfcode, AVG(unitprice) AS price 
FROM **(SELECT sfcode, unitprice, 
    @row_num := if(@code = sfcode, @row_num + 1, 0) as rowNumber, 
    @code := sfcode AS code 
    FROM transactions 
    WHERE doctype IN ('FP', 'LP') 
    ORDER BY sfcode, docdate DESC) AS g** 
WHERE g.rowNumber < @row_limit GROUP BY sfcode) 
AS e ON a.sfcode = e.sfcode ORDER BY sfcode;