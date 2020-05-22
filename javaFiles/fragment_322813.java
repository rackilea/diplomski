#!/bin/sh
### BEGIN INIT INFO
# Provides:          myapplication
# Required-Start:    $local_fs $remote_fs $network
# Required-Stop:     $local_fs $remote_fs $network
# Should-Start:      $named
# Should-Stop:       $named
# Default-Start:     2 3 4 5
# Default-Stop:      0 1 6
# Short-Description: Control myapplication
# Description:       Control the myapplication daemon.
### END INIT INFO

set -e

if [ -z "${JAVA_HOME}" ]; then
        JAVA_HOME=$(readlink -f /usr/bin/java | sed "s:/bin/java::")
fi
JAVA_OPTS="-Xms512m -Xmx1024m"

APP=myapplication

PID=/var/run/${APP}.pid
OUT_LOG=/var/log/myapplication/${APP}_out.log
ERR_LOG=/var/log/myapplication/${APP}_err.log

DAEMON_USER=yourserviceuser

APP_LOG_CONFIG=/etc/mycompany/${APP}_logback.xml
APP_CONFIG=/etc/mycompany/${APP}.conf
APP_HOME=/opt/${APP}
APP_CLASSPATH=$APP_HOME/${APP}.jar
APP_CLASS=com.example.myapplication.server.ApplicationDaemon

if [ -n "$APP_LOG_CONFIG}" ]; then
        JAVA_OPTS="-Dlogback.configurationFile=${APP_LOG_CONFIG} ${JAVA_OPTS}"
fi

DAEMON_ARGS="-home ${JAVA_HOME} -Dconfig.file=${APP_CONFIG} ${JAVA_OPTS} -pidfile ${PID} -user ${DAEMON_USER} -outfile ${OUT_LOG} -errfile ${ERR_LOG} -cp ${APP_CLASSPATH} ${APP_CLASS}"

. /lib/lsb/init-functions

case "$1" in
        start)
                log_daemon_msg "Starting ${APP}"
                cd ${APP_HOME} && jsvc ${DAEMON_ARGS}
                log_end_msg 0
                ;;
        stop)
                log_daemon_msg "Stopping ${APP}"
                cd ${APP_HOME} && jsvc -stop ${DAEMON_ARGS}
                log_end_msg 0
                ;;
        *)
                log_success_msg "Usage:  {start|stop}"
                echo "Usage:  {start|stop}"
                exit 1
                ;;
esac

exit 0