with toupdate as (
      select name, (select count(*) from tablename t2 where t2.QueuePosition <= t.QueuePosition) as QueuePosition
      from tablename t
     )
update tablename
    set QueuePosition = (select QueuePosition from toupdate where toupdate.name = tablename.name);