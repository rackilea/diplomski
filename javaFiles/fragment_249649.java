private static final String data = "100000    Farm    500000.00    101\n100001    Land    700000.00    104";

public static void main(String[] args) throws FileNotFoundException {
    int count = 0;
    double totalCost = 0;

    BufferedReader reader = new BufferedReader(new StringReader(data));
    String line;

    try {
        while ((line = reader.readLine()) != null) {
            StringTokenizer stok = new StringTokenizer(line);
            int propertyId = Integer.parseInt(stok.nextToken());
            String type = stok.nextToken();
            double cost = Double.parseDouble(stok.nextToken());
            int agentId = Integer.parseInt(stok.nextToken());

            totalCost += cost;
            count++;
        }
        // close input stream
    }
    catch (Exception e) {
        e.printStackTrace();
    }
    finally {
        System.out.println("Total properties in list: " + count + "\nTotal cost is: " + totalCost);
    }
}