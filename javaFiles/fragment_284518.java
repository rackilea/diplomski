Map<String, Set<String>> maps = ...

for(Entry<String, Set<String>> e : maps.entrySet()) {
   System.out.print(e.getKey());
   for(String s: e.getValue()) System.out.print(" " + s);
   System.out.println();
}