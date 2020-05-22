select  
    LAST_NAME, FIRST_NAME, trunc(FIELD_TIME) log_day,  min(FIELD_TIME) FIRST_LOG
from 
    log_time
group by 
    LAST_NAME, FIRST_NAME, trunc(FIELD_TIME)
order by 
    1, 2, 3;