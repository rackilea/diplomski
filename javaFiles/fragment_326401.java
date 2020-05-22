create materialized view check_mv
refresh complete on commit as
select 1 dummy
from catalogue c1, catalogue c2 
where c1.next_id = c2.previous_id and c1.parent_id != c2.parent_id

alter table check_mv
add constraint check_mv_chk
check (1=0) deferrable;