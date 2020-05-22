public class Products {

private String product;
private int price;

public Products(String product, int price){
    this.product = product;
    this.price = price;
}
public String getProduct(){
    return this.product;
}
public int getPrice(){
    return this.price;
}

@Override
public String toString(){
    return this.product +" "+ this.price;
}



public static void main(String[] args) throws ParseException {

    ArrayList<Products> list = new ArrayList<>();
    list.add(new Products("Hat",45));
    list.add(new Products("Socks",10));

    for (Products gd: list){
        if (gd.getProduct().equals("Hat")){
            int index = list.indexOf(gd);
            list.set(index,new Products(gd.getProduct(),gd.getPrice+10));
        }else {
            // if productName not found
            System.out.println("sorry products not available");
            break;
        }
    }

    System.out.println(list);

}