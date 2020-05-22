private static void mapStaticFields(Map<String, String> pMap, Class pStaticFieldHolder)
          throws NoSuchFieldException
  {
    if (pMap == null) return;
    for (Map.Entry<String, String> entry : pMap.entrySet())
    {
      try
      {
        Field field = pStaticFieldHolder.getDeclaredField(entry.getKey());
        field.setAccessible(true);
        field.set(field, entry.getValue());
      }
      catch (IllegalAccessException iae)
      {
        // impossible
      }
    }
}