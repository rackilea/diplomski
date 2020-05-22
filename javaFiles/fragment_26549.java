CREATE TABLE tenant ( ID integer primary key, version integer );
INSERT INTO tenant ( id, version ) values (1,0), (2,0), (3,0);

BEGIN;

PREPARE testq(integer) AS 
UPDATE tenant SET version = (SELECT (version + $1) FROM tenant WHERE ID = tenant.ID);

regress=> EXECUTE testq(1);
ERROR:  more than one row returned by a subquery used as an expression

ROLLBACK;