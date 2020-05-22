create table tab as
select 1 key1, 1 key2, 1 order1 from dual union all  -- dup
select 1 key1, 1 key2, 2 order1 from dual union all  -- dup
select 1 key1, 1 key2, 3 order1 from dual union all
select 1 key1, 2 key2, 1 order1 from dual union all
select 2 key1, 1 key2, 1 order1 from dual union all  -- dup
select 2 key1, 1 key2, 2 order1 from dual union all
select 2 key1, 2 key2, 1 order1 from dual;