create temporary table btest1
(id bigint,
"businessRule" bigint,
"actionType" character varying(100)
);

select id, businessRule, actionType from btest1;
ERROR:  column "businessrule" does not exist

select id, "businessRule", "actionType" from btest1;
 id | businessRule | actionType 
----+--------------+------------
(0 rows)