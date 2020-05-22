public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    String base = RandomStringUtils.random(80);
    long i = 0;
    try {
        while (i < 3e6) {
            list.add(base + i++);
        }
    } finally {
        System.out.println("Count:" + list.size());
        System.out.println("Memory:" + Runtime.getRuntime().totalMemory() / 1024d / 1024d);
    }
}