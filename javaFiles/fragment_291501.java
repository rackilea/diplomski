public class ClassName {

    private ArrayList<Order> sortedOrderList1;
    private ArrayList<Order> sortedOrderList2;

    public ClassName(ArrayList<Order> sortedOrderList1, ArrayList<Order> sortedOrderList2) {
        this.sortedOrderList1 = sortedOrderList1;
        this.sortedOrderList2 = sortedOrderList2;
    }

    public void method1(Order order) {
      //Modifies Order objects inside sortedOrderList1 or sortedOrderList2.
    }

    public method2(Order order) {
      //Modifies Order objects inside sortedOrderList1 or sortedOrderList1.
    }
}