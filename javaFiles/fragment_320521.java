String s = "replace_with_your_json_string";
    ObjectMapper mapper = new ObjectMapper();
    Map<String, Object> values = (Map<String, Object>) mapper.readValue(s, Map.class);
    iterate(values, "");

    private void iterate(Map<String, Object> map, String indent) {
            for(Map.Entry<String, Object> o : map.entrySet()) {
                    System.out.println(indent + o.getKey());
                    if(o.getValue() instanceof Map) {
                            iterate((Map<String, Object>) o.getValue(), indent + "\t");
                    }
                    if(o.getValue() instanceof List) {
                            iterate((List<Object>) o.getValue(), indent + "\t");
                    }
                    else if(o.getValue() instanceof String) {
                            System.out.println(indent + "\t" + o.getValue());
                    }
                    else if(o.getValue() instanceof Number) {
                            System.out.println(indent + "\t" + o.getValue());
                    }
            }
    }

    private void iterate(List<Object> list, String indent) {
            for(Object o : list) {
                    if(o instanceof Map) {
                            iterate((Map<String, Object>) o, indent + "\t");
                    }
                    if(o instanceof List) {
                            iterate((List<Object>) o, indent + "\t");
                    }
                    else if(o instanceof String) {
                            System.out.println(indent + "\t" + o);
                    }
                    else if(o instanceof Number) {
                            System.out.println(indent + "\t" + o);
                    }
            }
    }