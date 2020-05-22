INSERT INTO tempcalcplan
    SELECT v.conid, c.conname, v.rate, v.venid
    FROM venprices v LEFT JOIN
         country c
         ON c.conid = v.conid
    WHERE (v.conid, v.rate) IN ( SELECT v.conid, MIN(v.rate) FROM venprices v GROUP BY v.conid) GROUP BY v.conid");