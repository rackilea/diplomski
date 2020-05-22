with updated as (
  update test 
     set col1 = 'x', 
         col2 = 42,
         col3 = date '2018-02-07'
  where id = 1
  returning *         
)
select (o.col1 is distinct from u.col1)::int 
       + (o.col2 is distinct from u.col2)::int 
       + (o.col3 is distinct from u.col3)::int as columns_changed
from test o
  join updated u on u.id = o.id;