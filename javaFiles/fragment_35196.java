class Main {
    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap(3);
        map.put(1, null);
        map.put(2, null);
        map.put(3, null);
        map.put(4, null);
        System.out.println(map.keySet());
    }
}