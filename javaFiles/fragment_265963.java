#!/bin/sh
# cat ~/Desktop/charliebot/server.sh

# code from: http://sourceforge.net/projects/charliebot/

# also adapt the following files if necessary:
# ~/Desktop/charliebot/console.sh
# ~/Desktop/charliebot/targeting.sh
# ~/Desktop/charliebot/tester.sh

echo Starting Alicebot Program D.
ALICE_HOME="${HOME}/Desktop/charliebot"

cd "${ALICE_HOME}" || { echo "Could not cd to: ${ALICE_HOME}"; exit 1; }

SERVLET_LIB="${ALICE_HOME}/lib/servlet.jar"
ALICE_LIB="${ALICE_HOME}/lib/aliceserver.jar"
JS_LIB="${ALICE_HOME}/lib/js.jar"

# Set SQL_LIB to the location of your database driver.
SQL_LIB="${ALICE_HOME}/lib/mysql_comp.jar"

# These are for Jetty; you will want to change these if you are using a different http server.
HTTP_SERVER_LIBS="${ALICE_HOME}/lib/org.mortbay.jetty.jar"

PROGRAMD_CLASSPATH="${SERVLET_LIB}:${ALICE_LIB}:${JS_LIB}:${SQL_LIB}:${HTTP_SERVER_LIBS}"

export ALICE_HOME SERVLET_LIB ALICE_LIB JS_LIB HTTP_SERVER_LIBS PROGRAMD_CLASSPATH

#printf "\n\n\nPROGRAMD_CLASSPATH\n%s\n\n\n"  "$PROGRAMD_CLASSPATH" | tr ':' '\n'

exec java -classpath "$PROGRAMD_CLASSPATH" -Xms64m -Xmx128m org.alicebot.server.net.AliceServer $1