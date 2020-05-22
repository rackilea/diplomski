select cat, group_concat(name, ', ') 
from cats inner join
     associations using(id) inner join 
     items using (iid)
group by cat
order by id;