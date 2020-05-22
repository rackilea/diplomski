[alqualos@brededor tmp]$ mkdir -p 'String s1 = "something something ./files/icon.gif";'
[alqualos@brededor tmp]$ ll -d String*
drwxr-xr-x 3 alqualos alqualos   4096 2011-02-26 16:31 String s1 = "something something .
[alqualos@brededor tmp]$ ll String\ s1\ \=\ \"something\ something\ ./
total 4K
drwxr-xr-x 3 alqualos alqualos 4096 2011-02-26 16:31 files
[alqualos@brededor tmp]$ ll String\ s1\ \=\ \"something\ something\ ./files/
total 4K
drwxr-xr-x 2 alqualos alqualos 4096 2011-02-26 16:31 icon.gif";