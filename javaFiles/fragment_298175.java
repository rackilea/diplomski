java.util.Map<String, Long> map = new HashMap<>();
    Scanner read = new Scanner(file);
    while (read.hasNext()) {
        String line = read.nextLine();
        if(map.containsKey(line)) {
            map.put(line, map.get(line).longValue() + 1);
        } else {
            map.put(line, 1L);
        }
    }

    return map;