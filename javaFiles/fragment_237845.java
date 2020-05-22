SELECT t1.topper_position
       , t0.app_store_id
       , COALESCE(t2.topper_position, 6) - COALESCE(t1.topper_position, 6) AS delta2
       , COALESCE(t1.fetch_date, t2.fetch_date) AS cur_date
    FROM (SELECT DISTINCT app_store_id
            FROM crawler_2_application_details
           WHERE topper_position <= 5
             AND fetch_date IN ('2014-04-19 19:56:24', '2014-04-18 19:56:24')
         ) AS t0
    LEFT JOIN crawler_2_application_details AS t1
      ON t1.fetch_date = '2014-04-19 19:56:24' 
     AND t0.app_store_id = t1.app_store_id 
    LEFT JOIN crawler_2_application_details AS t2
      ON t2.fetch_date = '2014-04-18 19:56:24' 
     AND t0.app_store_id = t2.app_store_id 
   ORDER BY t1.topper_position IS NULL
          , t1.topper_position
  ;