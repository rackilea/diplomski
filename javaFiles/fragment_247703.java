# sqlite3
SQLite version 3.7.11 2012-03-20 11:35:50
Enter ".help" for instructions
Enter SQL statements terminated with a ";"
sqlite> create table foo (i text);
sqlite> insert into foo values ('a');
sqlite> insert into foo values ('b');
sqlite> .dump
PRAGMA foreign_keys=OFF;
BEGIN TRANSACTION;
CREATE TABLE foo (i text);
INSERT INTO foo VALUES('a');
INSERT INTO foo VALUES('b');
COMMIT;