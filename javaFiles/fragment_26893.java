Stream<Map<String, String>> result = queryKmAll.collect(Collectors.toMap(a1 -> a1.get("ID"),
            Function.identity(), (Map<String, String> m2, Map<String, String> m1) -> {
                m1.put("KMI",
                        String.valueOf(Double.parseDouble(m1.get("KMI")) + Double.parseDouble(m2.get("KMI"))));

                return m1;
            })).values().stream();

result.forEach(System.out::println);