String message = "The Quick brown fox jumps over the lazy brown dog the quick";
String[] split = message.split(" ");
Map<String, Integer> map = new HashMap<>();
int count = 0;
for (int i = 0; i < split.length - 1; i++) {
    String temp = split[i] + " " + split[i + 1];
    temp = temp.toLowerCase();
    if (message.toLowerCase().contains(temp)) {
        if (map.containsKey(temp))
            map.put(temp, map.get(temp) + 1);
        else
            map.put(temp, 1);
    }

}
System.out.println(map);