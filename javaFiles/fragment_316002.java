mkdir workDir
unzip yourJar.jar -d workDir
shopt -s globstar
for classFile in **/*.class; do
    echo "Classes used in $classFile :"
    javap -c "$classFile" | grep -Eo "([a-zA-Z0-9]+/)+[A-Z][a-zA-Z0-9]*" | sort -u
    echo
done