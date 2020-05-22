//first concatenate the two lists
Map<String, Map<String, Object>> result = Stream.concat(list1.stream(),
                                                        list2.stream())
                //then collect in a map where the key is the value of the month
                .collect(toMap(m -> (String) m.get("Month"),
                //the value is the map itself
                               m -> m,
                //merging maps (i.e. adding the "Sales" and "NoOfTranx" infos)
                               (m1, m2) -> {m1.putAll(m2); return m1; }));

//finally put that in a list
List<Map<String, Object>> merge = new ArrayList<>(result.values());