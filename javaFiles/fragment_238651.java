private final castToContext()Ljava/lang/Object;
 L0
  LINENUMBER 12 L0
    ALOAD 0
    GETFIELD CastTest.data : Ljava/lang/Object;
    DUP
    INSTANCEOF java/lang/Object // (1)
    IFNE L1                     // (1)
    POP          // (2)
    ACONST_NULL  // (2)
   L1
    ARETURN
   L2
    LOCALVARIABLE this LCastTest; L0 L2 0
    MAXSTACK = 2
    MAXLOCALS = 1