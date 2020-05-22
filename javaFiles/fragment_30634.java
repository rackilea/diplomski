int between10And20 = and(gt(10), lt(20));
/* BAD */ when(foo.quux(anyInt(), between10And20)).thenReturn(true);
// Mockito sees the stack as the opposite: and(gt(10), lt(20)), anyInt().

public static int anyIntBetween10And20() { return and(gt(10), lt(20)); }
/* OK */  when(foo.quux(anyInt(), anyIntBetween10And20())).thenReturn(true);
// The helper method calls the matcher methods in the right order.