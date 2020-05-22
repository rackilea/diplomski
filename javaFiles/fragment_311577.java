[ try { lock.newCondition().await(...) ...} ]
         /          |          \
        /           |           \
       /            |            \
Successful  InterruptedException  other exception
Execution           |                |
    |               |                |
[finally_copy1] [finally_copy2]   [finally_copy3]
    |               |                |
    |               |                |
[System.out]    [throw RuntimeEx] [throw the original exception]