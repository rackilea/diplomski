select a.*
from cluster_sosial a
left join cluster_sosial b
on a.cluster = b.cluster
and (
    length(a.content) < length(b.content)
    or (length(a.content) = length(b.content) and a.cluster_sosial_id < b.cluster_sosial_id)
)
where b.cluster is null;