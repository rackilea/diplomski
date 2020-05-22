class just.a.test.Main {
  just.a.test.Main();
    Code:
       0: aload_0
       1: invokespecial #1          // Method java/lang/Object."<init>":()V
       4: return

  public static <T> java.util.Optional<T> toJavaUtil(blub.Optional<T>);
    Code:
       0: aload_0
       1: ifnonnull     8
       4: aconst_null
       5: goto          12
       8: aload_0
       9: invokevirtual #2          // Method blub/Optional.toJavaUtil:()Ljava/util/Optional;
      12: areturn
}