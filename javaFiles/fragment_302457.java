public static void main(String[] args) throws FileNotFoundException {
    Gson gson = new Gson();
    BufferedReader br = new BufferedReader(new FileReader("base.json"));
    MyJson jsonOffline = gson.fromJson(br, MyJson.class);
    System.out.println("1 - Orderid: " + jsonOffline.getOrders().get("1").getIdOrder());
}