Node.class.simpleName        Identifier   Node.toString()
=====================        ==========   ===============
CompilationUnit                           class MyClass {...
ClassOrInterfaceDeclaration               class MyClass {...
SimpleName                   MyClass      MyClass
MethodDeclaration                         void main(String[] args) {...
SimpleName                   main         main
Parameter                                 String[] args
ArrayType                                 String[]
ClassOrInterfaceType                      String
SimpleName                   String       String
SimpleName                   args         args
VoidType                                  void
BlockStmt                                 {...
ExpressionStmt                            int a = 5, b = 6;
VariableDeclarationExpr                   int a = 5, b = 6
VariableDeclarator                        a = 5
PrimitiveType                             int
SimpleName                   a            a
IntegerLiteralExpr                        5
VariableDeclarator                        b = 6
PrimitiveType                             int
SimpleName                   b            b
IntegerLiteralExpr                        6
ExpressionStmt                            int c = a * b;
VariableDeclarationExpr                   int c = a * b
VariableDeclarator                        c = a * b
PrimitiveType                             int
SimpleName                   c            c
BinaryExpr                                a * b
NameExpr                                  a
SimpleName                   a            a
NameExpr                                  b
SimpleName                   b            b
ExpressionStmt                            System.out.println(c);
MethodCallExpr                            System.out.println(c)
FieldAccessExpr                           System.out
NameExpr                                  System
SimpleName                   System       System
SimpleName                   out          out
SimpleName                   println      println
NameExpr                                  c
SimpleName                   c            c