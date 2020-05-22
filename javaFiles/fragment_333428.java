#!/usr/bin/expect --
set timeout -1
set DBGPROMPT "\\\[1\\\] "
set OPENBRACE "\\\("
spawn ~/debug/jdk1.8.0_171/bin/jdb -attach 5005

# In case you had terminated on a suspended thread the last time
expect ">"
send -- "resume\r"


# add a breakpoint
expect ">"
send -- "stop in com.example.auth.MyClass.doStuff\r"

expect {
    -regex "Breakpoint hit.*com.example.auth.MyClass.doStuff$OPENBRACE.*$DBGPROMPT"
    {
        send "print myVal\r"
        exp_continue
    }
    -regex ".*tomcat-http.*$DBGPROMPT"
    {
        interact "\033\[19~" return
        send "cont\r"
        exp_continue
    }
}
interact