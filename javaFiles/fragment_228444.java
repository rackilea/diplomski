/**
 * Helper exception class which holds a method and arguments and
 * can call them. This is used as part of a trampoline to get rid of
 * the initial process setup stack frames.
 */
public static class MethodAndArgsCaller extends Exception
       implements Runnable { ... }