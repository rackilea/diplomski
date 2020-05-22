with toupdate as (
      select name, row_number() over (order by QueuePosition) as QueuePosition
      from tablename
     )
update tablename
    set QueuePosition = (select QueuePosition from toupdate where toupdate.name = tablename.name);