SELECT (SELECT open
        FROM SP_500 AS T
        WHERE T.date = MIN(SP_500.date)
       ) AS month_open,
       (SELECT close
        FROM SP_500 AS T
        WHERE T.date = MAX(SP_500.date)
       ) AS month_close,
       ...
FROM SP_500
GROUP BY strftime('%Y-%m', date / 1000, ...);