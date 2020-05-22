public final class StringUtilsKt {
 @NotNull
 public static final String getGreeting(@NotNull String $this$greeting) {
  Intrinsics.checkParameterIsNotNull($this$greeting, "$this$greeting");
  return "hello " + $this$greeting;
 }
}