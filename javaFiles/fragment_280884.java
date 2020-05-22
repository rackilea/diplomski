Map<String, Customer> res3 = customers.stream()
    .collect(
        HashMap::new, 
        (m,c) -> {m.put(c.first, c); m.put(c.last, c);}, 
        HashMap::putAll
    );