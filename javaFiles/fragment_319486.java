update link
set visiting = true
from (
    select id
    from link
    where visiting = false
    and visited = false
    limit 500
    for update
    ) as batch
where batch.id = link.id
returning *;