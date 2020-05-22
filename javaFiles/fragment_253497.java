select
    get_success_message('insert into test1 values(1)', 1) insert_1,
    get_success_message('insert into test1 values(1)', 0) insert_0,
    get_success_message('delete from test1', 50) delete_50
from dual;

INSERT_1         INSERT_0          DELETE_50
--------------   ---------------   ----------------
1 row created.   0 rows created.   50 rows deleted.