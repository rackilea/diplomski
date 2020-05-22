public class Main {
    public static void main(String[] args) {
        String jsonData = "...";
        final Gson gson = new Gson();
        Order o = gson.fromJson(jsonData, Order.class);
        System.out.println("orderId: " +  o.getOrderId());
        System.out.println("first article price: " + o.getArticles().get(0).getPrice());
        System.out.println("second article status: " + o.getArticles().get(1).getStatus());
        System.out.println("third article requested date: " + o.getArticles().get(2).getRequestedDate());
    }
}