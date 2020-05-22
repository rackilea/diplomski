WITH x(t) AS (VALUES ('2012-07-20 03:51:26+02'::timestamptz))
SELECT time_to_sec(t)  AS t1
      ,time_to_sec2(t) AS t2
      ,time_to_sec3(t) AS t3
      ,EXTRACT(EPOCH FROM t - current_date)::bigint AS t4
      ,EXTRACT(EPOCH FROM age(t, current_date))::bigint AS t5 -- deviates
      ,EXTRACT(EPOCH FROM age(t))::bigint * -1  AS t6  -- deviates
FROM   x;