Map<String, Set<Person>> groupBy = persons.parallelStream()
     .collect(HashMap::new, (m, p) -> { 
         m.computeIfAbsent(p.name, k -> new HashSet<>()).add(p); 
         m.computeIfAbsent(p.uid, k -> new HashSet<>()).add(p); 
         m.computeIfAbsent(p.phone, k -> new HashSet<>()).add(p); 
     }, (a, b) -> b.forEach((key, set) -> {
         a.computeIfAbsent(key, k -> new HashSet<>()).addAll(set));
     });