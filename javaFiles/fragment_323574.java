with
     inputs ( ts1, ts2 ) as (
       select to_timestamp_tz('12/26/2016 3:58:16.491476 AM -06:00',
                              'mm/dd/yyyy hh:mi:ss.ff AM TZH:TZM'),
              to_timestamp_tz('12/26/2016 3:58:16.491476 AM +05:00', 
                              'mm/dd/yyyy hh:mi:ss.ff AM TZH:TZM') from dual
     )
select ts1, ts2, case when ts1 > ts2 then 'ts1 > ts2' 
                      when ts1 = ts2 then 'ts1 = ts2'
                      when ts1 < ts2 then 'ts1 < ts2'
                 end as comparison,
       ts1 - ts2 as difference
from inputs
;

TS1                           TS2                           COMPARISON DIFFERENCE
----------------------------- ----------------------------- ---------- -------------------
26-DEC-16 03.58.16.491 AM -06 26-DEC-16 03.58.16.491 AM +05 ts1 > ts2  +00 11:00:00.000000