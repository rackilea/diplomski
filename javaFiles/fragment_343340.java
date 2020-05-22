/**
 * Add two long's with overflow detection (r = s + d)
 */
public static long add(final long s, final long d){
    final long r = s + d;
    if (((s & d & ~r) | (~s & ~d & r)) < 0)
        throw new RuntimeException("long overflow add(" + s + ", " + d + ")");
    return r;
}