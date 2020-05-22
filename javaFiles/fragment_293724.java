with updated as (
  update test 
     set col1 = 'x', 
         col2 = 42,
         col3 = date '2018-02-07'
  where id = 1
  returning *         
)
select hstore(u) - hstore(o) as modified_columns
from test o
  join updated u on u.id = o.id;