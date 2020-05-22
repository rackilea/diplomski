// source: https://github.com/parrt/cs652/blob/master/labs/symtab-mono/src/symtab/Scope.java
public interface Scope {
    String getScopeName();
    void define(Symbol s);
    Symbol resolve(String name); // bind or lookup
    Scope getEnclosingScope();
}