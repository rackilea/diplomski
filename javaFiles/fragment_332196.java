# Ensure that any user defined CLASSPATH variables are not used on startup,
 # but allow them to be specified in setenv.sh, in rare case when it is needed.
 if [ -r "$CATALINA_BASE/bin/setenv.sh" ]; then
  . "$CATALINA_BASE/bin/setenv.sh"
 elif [ -r "$CATALINA_HOME/bin/setenv.sh" ]; then
  . "$CATALINA_HOME/bin/setenv.sh"
 fi