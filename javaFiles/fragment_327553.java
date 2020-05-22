with start_and_end_dates as (select min(onlydate) min_date
,max(onlydate) max_date
from mytable
where name='ABCD'),

missing_dates as (select min_date + level-1  as date_value 
from start_and_end_dates connect by level <=(max_date - min_date) + 1)

select distinct id,name,date_value
from mytable,missing_dates
where name='ABCD'
order by date_value;