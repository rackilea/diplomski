public scala.Tuple2<java.lang.Object, java.lang.String> intAndStringNullTuple();
  Code:
     0: new           #27                 // class scala/Tuple2
     3: dup
     4: aconst_null
     5: invokestatic  #18                 // Method scala/runtime/BoxesRunTime.unboxToInt:(Ljava/lang/Object;)I
     8: invokestatic  #31                 // Method scala/runtime/BoxesRunTime.boxToInteger:(I)Ljava/lang/Integer;
     11: ldc           #33                 // String 2
     13: invokespecial #36                 // Method scala/Tuple2."<init>":(Ljava/lang/Object;Ljava/lang/Object;)V
     16: areturn