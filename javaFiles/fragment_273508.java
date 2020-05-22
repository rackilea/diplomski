List<String> results= new ArrayList<>();    
map.entrySet().stream()
        .forEach(aList -> 
            aList.getValue().removeIf(a -> {
                if (a.result == null) {
                    return true;
                }
                if (results.stream().filter(result -> result.equalsIgnoreCase(a.result)).count() > 0) {
                    return true;
                }
                results.add(a.result);
                return false;
            }));