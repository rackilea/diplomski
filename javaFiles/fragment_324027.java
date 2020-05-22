JAVA_HOME=/path/to/JDK8

# Run the compiler
${JAVA_HOME}/bin/java java $COMPILER_OPTS -cp "$COMPILER_CLASSPATH" io.gatling.compiler.ZincCompiler -ccp "$COMPILATION_CLASSPATH" "$@"  2> /dev/null

# Run Gatling
${JAVA_HOME}/bin/java $JAVA_OPTS -cp "$GATLING_CLASSPATH" io.gatling.app.Gatling "$@"