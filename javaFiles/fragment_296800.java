Map<String, Runnable> map = new HashMap();
map.put("method1", new Runnable() { ... });
map.put("method2", new Runnable() { ... });
map.put("method3", new Runnable() { ... });

for (Map.Entry entry : ...) {
   map.get(entry.getKey().getSimpleName()).run();
}