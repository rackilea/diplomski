ArrayList<ArrayList<Double>> list = new ArrayList<>();
while ((line = bufferReader.readLine()) != null)   {
    ArrayList<Double> curr = new ArrayList<>();
    Scanner sc = new Scanner(line);
    while (sc.hasNextDouble()) {
        curr.add(sc.nextDouble());
    }
    list.add(curr);
}