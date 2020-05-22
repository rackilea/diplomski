create or replace view V_CHILD as
   select
   NAME VARCHAR2,
   TYPE VARCHAR2,
   CASE WHEN type='GIRL' THEN 1 WHEN type='BOY' THEN 2 ELSE 3 END as TYPE_ORDER
   from CHILD;