;with cte as (
select c.*
from information_schema.tables t
  inner join information_schema.columns c
    on t.table_schema = c.table_schema
   and t.table_name = c.table_name
where t.table_type='base table'
)
, match as (
select 
    tables = l.table_name + ' & ' + r.table_name
  , l.column_name
from cte l
  inner join cte r
    on l.column_name = r.column_name
   and l.table_name < r.table_name
)
select 
    tables
  , columns = stuff((
  select ', '+ column_name
  from match i
  where m.tables = i.tables
  for xml path (''), type).value('(./text())[1]','nvarchar(max)')
  ,1,2,'')
  , matches = count(*)
from match m
group by tables