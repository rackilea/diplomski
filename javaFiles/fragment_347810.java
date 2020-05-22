# generate a lexer and parser:
java -cp antlr-3.2.jar org.antlr.Tool REPL.g

# compile all .java source files:
javac -cp antlr-3.2.jar *.java

# run the main class on Windows:
java -cp .;antlr-3.2.jar Main 
# or on Linux/Mac:
java -cp .:antlr-3.2.jar Main