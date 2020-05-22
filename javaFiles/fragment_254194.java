Try this 
select es.p_id,es.weekenddate-( CASE 
                             WHEN SUN != 0 THEN 0 
                             WHEN SAT != 0 THEN 1 
                             WHEN FRI != 0 THEN 2 
                             WHEN THR != 0 THEN 3 
                             WHEN WED != 0 THEN 4 
                             WHEN TUE != 0 THEN 5 
                             ELSE 6 
                           END )  from(
select p_id,max(weekenddate)dt from effort_sheet group by p_id
  )inner,effort_sheet es
where inner.p_id =es.p_id
AND inner.dt=es.weekenddate;