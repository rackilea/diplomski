$ cat file.txt 
hello world, how are you?1e3djw
hello world, how are you?1e3djw adfa asdfas

$ cat file.txt | java Dict | gzip -d | cmp file.txt ; echo $?
0