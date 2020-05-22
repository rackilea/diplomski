with b as (
      Select *
      from DVDs
      where type = 'Movie' and title = 'Black Butterfly'
     )
select b.*
from b
union all
select d.*
from dvd
where type = 'Movie' and not exists (select 1 from b);