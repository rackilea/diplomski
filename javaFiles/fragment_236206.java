java.lang.reflect.Method  run   = Class.forName ("java.io.DeleteOnExitHook").getDeclaredMethod ("runHooks");
    java.lang.reflect.Field   files = Class.forName ("java.io.DeleteOnExitHook").getDeclaredField  ("files");

    run.setAccessible (true);
    files.setAccessible (true);

    run.invoke (null);
    files.set (null, new java.util.LinkedHashSet <String> ());