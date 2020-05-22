public abstract class Item {
    private int code;
    private double price;
    private boolean isOnGST;

    public Item()
    {

    }
    public Item(int code,double price,boolean isOnGST)
    {
        this.code = code;
        this.price = price;
        this.isOnGST = isOnGST;
    }
    public void setGST(boolean isgst)
    {
        this.isOnGST = isgst;
    }
    public int getCode()
    {
        return code;
    }
    public boolean getIsOnGST()
    {
        return isOnGST;
    }
    public double getCurrentPrice()
    {
        return price;
    }
    public String toString() {
        return "Item [code=" + code + ", price=" + price + ", isOnGST=" + isOnGST + "]";
    }
    public abstract String printBudgetGST();
    public abstract boolean isOnBudget();
}

class ClothingItem extends Item {
    public ClothingItem() {

    }

    public ClothingItem(int code, double price, boolean isOnGST) {
    super(code, price, isOnGST);
    }

    @Override
    public String printBudgetGST() {
    String stringitem = "";
    double finalprice = (0.06 * getCurrentPrice()) + getCurrentPrice();
    stringitem = stringitem + " " + "ClothingItem : " + getCode() + ":" + "RM" + finalprice;

    return stringitem;
    }

    @Override
    public boolean isOnBudget() {
    return getCurrentPrice() < 100.00;
    }
}

class SportsItem extends Item {
    public SportsItem() {
    }

    public SportsItem(int code, double price, boolean isOnGST) {
    super(code, price, isOnGST);
    }

    public String printBudgetGST() {
    String stringitem = "";
    double finalprice = (0.06 * getCurrentPrice()) + getCurrentPrice();
    stringitem = stringitem + "SportsItem : " + getCode() + ":" + "RM" + finalprice;
    return stringitem;
    }

    @Override
    public boolean isOnBudget() {
    return getCurrentPrice() < 150.00;
    }
}

class Retail_Item
{
    private Item[] itemList;

    public Retail_Item()
    {
    itemList = new Item[10];
    itemList[0] = new ClothingItem(10001,85,true);
    itemList[1] = new ClothingItem(10002,150,false);
    itemList[2] = new ClothingItem(10003,168,true);
    itemList[3] = new ClothingItem(10004,43,true);
    itemList[4] = new ClothingItem(10005,162,false);
    itemList[5] = new SportsItem(10006,178,false);
    itemList[6] = new SportsItem(10007,80,true);
    itemList[7] = new SportsItem(10008,191,false);
    itemList[8] = new SportsItem(10009,45,true);
    itemList[9] = new SportsItem(10010,121,true);
    }

    public  void printItem() {
    for(int i =0 ;i<itemList.length;i++) {
        if(itemList[i].getIsOnGST()==true && itemList[i].printBudgetGST().length()>0 && itemList[i].isOnBudget())
        {

        System.out.println(itemList[i].printBudgetGST());
        }
    }
    }
}

class TestRetailItem {
    public static void main(String[] args) {
    Retail_Item ret = new Retail_Item();
    ret.printItem();
    }
}