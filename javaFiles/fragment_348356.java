update tablename t
inner join (
  select t.*,
    (select count(*) from tablename
    where taskid = 6 and status = 'ACTIVE' and position < t.position) + 1 counter
  from tablename t
) g on g.taskid = t.taskid and g.taskDetailId = t.taskDetailId 
set t.position = g.counter
where t.taskid = 6;