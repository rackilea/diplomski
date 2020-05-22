Map<String, Double> map = new HashMap<>();
map.put("Jon", 5.5);
map.put("Susi", 10.1);
map.put("Linda", 10.1);
map.put("Loar", 4.);
map.put("Ivan", 5.);
map.put("Kevin", 10.1);

map.entrySet().stream()
   .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
   .forEach(System.out::println);