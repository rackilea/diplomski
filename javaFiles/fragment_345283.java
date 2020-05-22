private static void assertTrue(boolean x)
  {
    if (!x)
    {
      throw new AssertionError();
    }
  }

  public static void main(String[] args)
  {
    SetMultimap<String, String> sm = LinkedHashMultimap.create();

    List<Map.Entry<String, String>> entries = Arrays.asList(
        new AbstractMap.SimpleEntry<>("z", "z"),
        new AbstractMap.SimpleEntry<>("a", "a"),
        new AbstractMap.SimpleEntry<>("x", "x"),
        new AbstractMap.SimpleEntry<>("z", "x") // Multiple values per key OK
    );

    for (Map.Entry<String, String> entry : entries)
    {
      assertTrue(sm.put(entry.getKey(), entry.getValue()));
    }

    assertTrue(!sm.put("z", "z")); // Duplicate not added

    // Check iterator ordering is same as insertion order
    Iterator<Map.Entry<String, String>> i1 = sm.entries().iterator();
    Iterator<Map.Entry<String, String>> i2 = entries.iterator();
    while (i1.hasNext() && i2.hasNext())
    {
      assertTrue(i1.next().equals(i2.next()));
    }
    // Check same number of elements in both collections
    assertTrue(!i1.hasNext() && !i2.hasNext());
  }