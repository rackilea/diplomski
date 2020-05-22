call interval_between('"+ startDate +"', '" + endDate + "', 'DAY', 1);

select day(ti.interval_from), count(prop.docfullName) from time_intervals ti left join propClass as prop 
on prop.docCreationDate>=ti.interval_from AND prop.docCreationDate < ti.interval_from + INTERVAL 1 DAY
where ti.interval_from>='"+ startDate +"' and ti.interval_from < '" + endDate + "'
group by ti.interval_from;