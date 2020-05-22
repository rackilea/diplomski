public class IdGenerator 
{
  private IdGenerator() {} // no instantiation or subclassing
  private static final ConcurrentMap<String, AtomicLong> ids =
    new ConcurrentHashMap<String, AtomicLong>();

  public static long id(String key) {
    AtomicLong al = ids.get(key);
    if (al == null) {
      final AtomicLong newL = new AtomicLong(0);
      al = ids.putIfAbsent(key, newL);
      if (al == null) al = newL;
    }
    return al.getAndIncrement();
  }
}