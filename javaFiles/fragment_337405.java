select a.*
from my_table a
inner join (
    select cluster, max(length(content)) len
    from my_table
    group by cluster
) b on a.cluster = b.cluster and length(a.content) = b.len;