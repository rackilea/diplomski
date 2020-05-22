EXCLUDED="slf4j-log4j12-1.4.3.jar
some-other-library.jar
something-else.jar"

EXTERNAL_JARS=$(
  find "${EXTERNAL_LIB}" -type f -name '*.jar' \
    | grep -v -F"$EXCLUDED" \
    | xargs \
    | tr ' ' ':'
)

CLASSPATH=${CLASSPATH}:${EXTERNAL_JARS}