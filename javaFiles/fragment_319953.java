public static void assertMapEquals(Map<?, ?> f, Map<?, ?> l) {
     if (f == null || l == null)
         throw new NullPointerException();
     if (f.size() != l.size())
         throw new AssertionError("size mismatch");
     if (!f.equals(l))
         throw new AssertionError("unequal contents");
}