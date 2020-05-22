Entry<String, String> ent =
            map.entrySet().stream().reduce(Map.entry("0", "0000-00-00"),
                  (a, b) -> b.getValue().compareTo(a.getValue()) >= 0 ? b
                        : a);

         System.out.println(ent.getKey() + " -> " ent.getValue());