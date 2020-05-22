import sun.misc.Unsafe;

...

Field theUnsafeField = Unsafe.class.getDeclaredField("theUnsafe");
theUnsafeField.setAccessible(true);
Unsafe theUnsafe = (Unsafe)theUnsafeField.get(null);