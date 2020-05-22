default:
    javac -d EXE src/presentation/*.java src/data/*.java src/domain/controllers/*.java
runMain: default
    java -cp EXE presentation.Main
jar: default
    cd EXE; jar cfe run.jar presentation.Main .;mv run.jar ..