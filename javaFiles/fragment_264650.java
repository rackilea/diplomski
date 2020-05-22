peregrino:$ javac -d bin -g:none src/Relation.java 
peregrino:$ javap -classpath bin -l -c Relation | head
public class Relation extends java.lang.Object{
  ...

peregrino:$ javac -d bin -g:source src/Relation.java 
peregrino:$ javap -classpath bin -l -c Relation | head
Compiled from "Relation.java"
public class Relation extends java.lang.Object{
  ...