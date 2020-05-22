# savepoint bar;
SAVEPOINT
# insert into foo values(2);
INSERT 0 1
# insert into foo values(2);
ERROR:  duplicate key value violates unique constraint "foo_pkey"