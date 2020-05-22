HashSet<String> result = new HashSet<String>();

for (String a : finalMap.get(0)) {
    for (String b : finalMap.get(1)) {
        for (String c : finalMap.get(2)) {
            for (String d : finalMap.get(3)) {
                result.add(a + b + c + d);
            }
        }
    }
}
System.out.println(result);