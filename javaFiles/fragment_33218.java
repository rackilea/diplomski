#!/bin/sh

case "$1" in
start)
    java /path/to/my/java/program.jar &
    echo $! > /var/run/my-java-program.pid
    ;;

stop)
    if [ ! -f /var/run/my-java-program.pid ]; then
        echo "my-java-program: not running"
        exit 1
    fi

    kill -TERM `cat /var/run/my-java-program.pid`
    ;;

reload)
    if [ ! -f /var/run/my-java-program.pid ]; then
        echo "my-java-program: not running"
        exit 1
    fi

    kill -HUP `cat /var/run/my-java-program.pid`
    ;;

*)
    echo "Usage: /etc/init.d/my-java-program {start|stop|reload}"
    exit 1
    ;;

esac

exit 0