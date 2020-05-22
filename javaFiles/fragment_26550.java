BEGIN;

PREPARE testq2(integer) AS 
UPDATE tenant SET version = (SELECT (version + $1) FROM tenant t2 WHERE t2.ID = tenant.ID);

regress=> EXECUTE testq2(1);
UPDATE 3

ROLLBACK;