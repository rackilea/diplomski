SELECT v.conid, c.conname, v.rate, v.venid
    FROM venprices v LEFT JOIN
         country c
         ON c.conid = v.conid JOIN
         (SELECT v.conid, MIN(v.rate) as rate
          FROM venprices v
          GROUP BY v.conid
         ) vr
         ON v.conid = vr.conid and v.rate = vr.rate;