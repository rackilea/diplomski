#!/bin/bash
CATOUT=/opt/tomcat/logs/catalina.out
DUMPSTART=$(grep -n dump|tail -n1|cut -d':' -f1)
DUMPEND=$(wc -l $CATOUT|cut -d' ' -f1)

kill -3 $(pidof java)
sed -n "${DUMPSTART},${DUMPEND)p" $CATOUT |mail -s "Java thead dump" myemail@foo.com