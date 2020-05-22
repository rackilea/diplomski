final Map<String, String> output = 
           input.entrySet()
                .stream()
                .collect(Collectors.toMap(
                    o -> o.getKey(),              
                    o -> o.getValue().getName()
                ));