List<String> addressList = new ArrayList<>(Arrays.asList("192.168.0.5", // 
        "192.168.0.1", "192.168.25.1", "192.168.10.21", "192.168.77.1"));
Collections.sort(addressList, (a, b) -> {
    int[] aOct = Arrays.stream(a.split("\\.")).mapToInt(Integer::parseInt).toArray();
    int[] bOct = Arrays.stream(b.split("\\.")).mapToInt(Integer::parseInt).toArray();
    int r = 0;
    for (int i = 0; i < aOct.length && i < bOct.length; i++) {
        r = Integer.compare(aOct[i], bOct[i]);
        if (r != 0) {
            return r;
        }
    }
    return r;
});
System.out.println(addressList);