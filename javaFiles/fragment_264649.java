peregrino:$ javac -d bin -g:none src/Relation.java 
peregrino:$ javap -classpath bin -l Relation 
public class Relation extends java.lang.Object{
public Relation();

peregrino:$ javac -d bin -g:lines src/Relation.java 
peregrino:$ javap -classpath bin -l Relation 
public class Relation extends java.lang.Object{
public Relation();
  LineNumberTable: 
   line 1: 0
   line 33: 4

peregrino:$ javac -d bin -g:vars src/Relation.java 
peregrino:$ javap -classpath bin -l Relation 
public class Relation extends java.lang.Object{
public Relation();

  LocalVariableTable: 
   Start  Length  Slot  Name   Signature
   0      5      0    this       LRelation;