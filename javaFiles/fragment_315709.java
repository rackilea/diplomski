public static void main(String[] args) {
      System.out.println("\n===== ConcurrentHashMap =====");
      testMap(new ConcurrentHashMap<>());
      System.out.println("\n===== Collections.synchronizedMap()  =====");
      testMap(Collections.synchronizedMap(new HashMap<>()));
}

    static final int N = 5;
    static final int R = 1000000;

    public static void testMap(Map map) {
        long startTime = System.nanoTime();

        System.out.println("\n-- " + N*R + " puts(key, value) --");
        startTime = System.nanoTime();
        for (int j = 0; j < R; j++) {
            for (int i = 0; i < N; i++) 
                map.put(i, new float[] { 0f, 1f, 2f, 3f, 4f });
            map.clear();
        }
        System.out.println((System.nanoTime() - startTime) / 1000000000.0);

        System.out.println("\n-- " + N*R + " get(key) --");
        startTime = System.nanoTime();
        for (int j = 0; j < R; j++) {
            for (int i = 0; i < N; i++)  
                map.get(i); 
            map.clear();
        }
        System.out.println((System.nanoTime() - startTime) / 1000000000.0);
    }

}