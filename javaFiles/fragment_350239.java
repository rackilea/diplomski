static void updateYmlContent(Map<String, ?> ymlMap, String value, String... keys) {
    int depth = 0;
    findAndReplaceContent(ymlMap, value, keys, depth);
}

static void findAndReplaceContent(Map map, .......) {
  if (map.containsKey(keys[depth]))
  {
    if (depth == keys.length - 1)
    {
      // found it
      map.put(keys[depth], value);
      // done
    }
    else
    {
      findAndReplaceContent(map.get(keys[depth]), value, keys, depth+1);
    }
  }
  else
  {
    // throw key not found
  }
}