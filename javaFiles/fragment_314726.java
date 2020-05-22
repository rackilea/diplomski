sqlite> pragma foreign_keys=1;
sqlite> create table foo (a int, b int);
sqlite> create table bar (c int, d int, foreign key (c) references foo(b));
sqlite> insert into foo values (1,1);
sqlite> insert into bar values (1,1);
Error: foreign key mismatch
sqlite> create unique index idx1 on foo(b);
sqlite> insert into bar values (1,1);
sqlite>