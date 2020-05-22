xd:>hadoop config fs --namenode hdfs://node1:8020

xd:>hadoop fs ls --recursive true --dir /xd
lsr: `/xd': No such file or directory

xd:>stream create --name test --definition "http|hdfs" --deploy
Created and deployed new stream 'test'

xd:>http post --data "hello" http://localhost:9000
> POST (text/plain;Charset=UTF-8) http://localhost:9000 hello
> 200 OK

xd:>hadoop fs ls --recursive true --dir /xd
drwxr-xr-x   - jvalkealahti supergroup          0 2014-07-14 21:33 /xd/test
-rw-r--r--   3 jvalkealahti supergroup          0 2014-07-14 21:33 /xd/test/test-0.txt.tmp

xd:>stream destroy --name test 
Destroyed stream 'test'

xd:>hadoop fs ls --recursive true --dir /xd
drwxr-xr-x   - jvalkealahti supergroup          0 2014-07-14 21:33 /xd/test
-rw-r--r--   3 jvalkealahti supergroup          6 2014-07-14 21:33 /xd/test/test-0.txt

xd:>hadoop fs cat --path /xd/test/test-0.txt
hello