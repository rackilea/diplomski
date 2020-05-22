public static void assertMapEquals(Map<?, ?> f, Map<?, ?> l) {
    if (f == null || l == null)
         throw new NullPointerException();
    if (f.size() != l.size()) 
            throw new AssertionError ("size mismatch");
    for (Entry<?, ?> ent : f.entrySet()) {            
        Object k = ent.getKey();
        Object e = ent.getValue();
        Object a = l.get(k);        
        if (!Objects.equals(e, a))      // handle null values
            throw new AssertionError("unequal");
    }
}