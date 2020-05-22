String[] a = s.replaceAll("[{}]", "").split("=", 2);
    int key = Integer.parseInt(a[0].trim());
    HashMap<Integer, Integer> innerMap = new HashMap<>();
    for (String e : a[1].split(",")) {
        a = e.split("=");
        innerMap.put(Integer.parseInt(a[0].trim()),  Integer.parseInt(a[1].trim()));
    }
    fullMap.put(key, innerMap);