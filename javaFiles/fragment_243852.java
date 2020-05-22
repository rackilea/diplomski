create table worktime_stackoverflow (id int, DateTime datetime);
delete from worktime_stackoverflow where id > 0;
insert into worktime_stackoverflow values (1, '2017-05-15 18:14:13');
insert into worktime_stackoverflow values (2, '2017-05-16 06:30:05');
insert into worktime_stackoverflow values (3, '2017-05-17 22:30:45');
insert into worktime_stackoverflow values (4, '2017-05-18 09:30:05');
insert into worktime_stackoverflow values (5, '2017-05-20 10:45:15');
insert into worktime_stackoverflow values (6, '2017-05-20 19:31:25');
insert into worktime_stackoverflow values (5, '2017-05-21 16:45:15');
insert into worktime_stackoverflow values (6, '2017-05-22 03:17:25');


select DATE(w.DateTime) day_of_report
  # Start of nightshift
, CONCAT(DATE(MIN(w.DateTime)), ' ' , '22:00:00') start_nightshift,
  # actual start of work
       MIN(w.DateTime) start_of_work,
  # mathematical max() of the two
       GREATEST(
          CONCAT(DATE(MIN(w.DateTime)), ' ' , '22:00:00'),
          Min(w.DateTime)
        ) nightshift_work_start,
  # end of nightshift-hours
        CONCAT(ADDDATE(DATE(MIN(w.DateTime)), INTERVAL 1 DAY), ' ' , '07:00:00') end_nightshift
  # the following worklog entry (= end of work)
        ,(SELECT MIN(w2.DateTime) as following_time FROM worktime_stackoverflow w2 WHERE w2.DateTime > w.DateTime AND TIME(w2.DateTime) < '12:00:00'
                  AND DATEDIFF(w2.DateTime, w.DateTime) < 2) as end_of_work
  # mathematical minimum of these two
      ,LEAST(
           (SELECT MIN(w2.DateTime) as following_time FROM worktime_stackoverflow w2 WHERE w2.DateTime > w.DateTime AND TIME(w2.DateTime) < '12:00:00'
              AND DATEDIFF(w2.DateTime, w.DateTime) < 2),
          CONCAT(ADDDATE(DATE(MIN(w.DateTime)), INTERVAL 1 DAY), ' ' , '07:00:00')
          ) nightshift_work_end  
from worktime_stackoverflow w
   # make sure to not use end-of-nightshift loutout times
   where TIME(w.DateTime) > '12:00:00'
GROUP by DATE(w.DateTime);