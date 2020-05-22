cd $JAR_DIR
 jars=($(ls *.jar))
 JAR_PATH=""
 dir=$(pwd)
 for i in "${jars[@]}"; do
    JAR_PATH="${JAR_PATH}:$dir/$i"
 done
 CLASSPATH=$CLASSPATH:$JAR_PATH