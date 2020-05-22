.class public CallAmbiguousMethod
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
  .limit stack 3
  .limit locals 1

  ; Call the method that returns String
  aconst_null
  invokestatic   TestWillThatCompile/f(Ljava/util/List;)Ljava/lang/String;

  ; Call the method that returns Integer
  aconst_null
  invokestatic   TestWillThatCompile/f(Ljava/util/List;)Ljava/lang/Integer;

  return

.end method