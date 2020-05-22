MAX_RAM=$(cgget -nvr memory.limit_in_bytes /)
if [ $MAX_RAM -le 137438953472 ] ; then
    JVM_MIN_HEAP=$(printf "%.0f" $(echo "${MAX_RAM} * 0.2" | bc))
    JVM_MAX_HEAP=$(printf "%.0f" $(echo "${MAX_RAM} * 0.8" | bc))
else
    JVM_MIN_HEAP=32G
    JVM_MAX_HEAP=128G
fi

exec java "-Xms${JVM_MIN_HEAP}" "-Xmx${JVM_MAX_HEAP}" -jar my_jar.jar