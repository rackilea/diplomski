Map<Tuple7<Integer, String, Double, String, String, String, String>, 
Double> result2 = new LinkedHashMap<>();
    unsortMap.entrySet().stream()
            .sorted(Map.Entry.<Tuple7<Integer, String, Double, String, 
String, String, String>, Double>comparingByValue().reversed())
            .forEachOrdered(x -> result2.put(x.getKey(), x.getValue()));