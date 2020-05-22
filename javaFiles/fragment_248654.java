public class InventoryFinal {

    String partNo;
    String prodDesc;
    int quantity;

    public static void main(String[] args) {
        //create new instances and call methods from here
    }

    public InventoryFinal() {
        partNo = "AA0000";
        prodDesc = "Test Item";
        quantity = 0;
    }

    public InventoryFinal(String s, String s2, int i) {
        partNo = s;
        prodDesc = s2;
        quantity = i;
    }

    public void setPartNo(String sSet) {
        partNo = sSet;
    }

    public void setProdDesc(String sSet2) {
        prodDesc = sSet2;
    }

    public void setQuantity(int iSet) {
        quantity = iSet;
    }

} // close class