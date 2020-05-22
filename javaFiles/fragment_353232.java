public static void euclidianDistanceFromFile(String path) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(path));
    String line;
    while ((line = br.readLine()) != null) {
        if (line.contains("ID")) continue;
        String[] arr = line.split(",");
        String name = arr[0];
        double p = Double.parseDouble(arr[1]);
        double q = Double.parseDouble(arr[2]);
        double res = Math.sqrt((p - q) * (p - q));
        System.out.println(name + ": " + res);
    }
}