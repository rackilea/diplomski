final JDefinedClass exampleClass = codeModel._class( "com.example.ExampleClass" );
final JMethod method = exampleClass.method( JMod.PUBLIC, Object.class, "getValue" );
final JTypeVar t = method.generify( "T" );
method.type( t );
method.param( codeModel.ref( Class.class ).narrow( t ), "type" );
method.body()._return(JExpr._null());