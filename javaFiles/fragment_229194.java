SELECT * INTO AnotherTest IN 'Z:\Docs\test.accdb'
FROM test;

INSERT INTO AnotherTest IN 'Z:\Docs\test.accdb'
SELECT  *
FROM test;