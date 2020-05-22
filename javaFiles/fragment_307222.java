public static void main(String[] args) throws Exception {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
        int n = Integer.parseInt(reader.readLine());
        System.out.println(n);
        while (n-- > 0) {
            int i = Integer.parseInt(reader.readLine());
            System.out.println(i);
        }
    }
}