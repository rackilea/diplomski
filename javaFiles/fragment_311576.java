[ try { lock.newCondition().await(...) ...} ]
         /          |          \
        /           |           \
       /            |            \
Successful  InterruptedException  other exception
Execution           |               /
     \              |              /
      \             |             /
       \            |            /
     [ finally {  lock.unlock;  }  ]
       /            |            \
      /             |             \
     /              |              \
    |               |               |
[System.out]    [throw RuntimeEx] [throw the original exception]