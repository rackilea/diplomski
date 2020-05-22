select a.*
from my_table a
left join my_table b
on a.cluster = b.cluster
and length(a.content) < length(b.content)
where b.cluster is null;