List<String> a2 = ...; //your list
        Collections.sort(a2, 
                    Collections.reverseOrder((s1, s2) -> {
                        String[] d1 = s1.split(",");
                        String[] d2 = s2.split(",");
                        return Double.compare(Double.parseDouble(d1[d1.length-1]), 
                                              Double.parseDouble(d2[d2.length-1]));
                    }));

a2.forEach(System.out::println);