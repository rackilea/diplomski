SELECT
  SUM(case when $P{oneDayAgo} <= datetime then count else 0 end) as 'today',
  SUM(case when $P{oneWeekAgo} <= datetime then count else 0 end) as 'thisweek',
  SUM(count) as 'thismonth'
FROM
  statistics
WHERE
   name = "test"
  AND $P{oneMonthAgo} <= datetime
  AND datetime <= $P{now}