long startMemory = getMemoryUsage();
final LinkedList<String> strings = new LinkedList<>();
final SecureRandom random = new SecureRandom();
   for (int i = 0; i < 600; i++) {
       final String e = new BigInteger(130, random).toString(32);
       strings.add(e);
    }
      long endMemory = getMemoryUsage();

      int size = (endMemory - startMemory )