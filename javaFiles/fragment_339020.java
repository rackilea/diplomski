import java.io.Serializable; 
public class myProduct implements Serializable{

    @SerializedName("productID")
    public int productID;
    @SerializedName("categoryID")
    public int categoryID;
    @SerializedName("productName")
    public String productName;
    @SerializedName("productPrice")
    public int productPrice;

    public int productQuantity = 0;

    public myProduct(int productID, int categoryID, String productName, int productPrice){
        this.productID = productID;
        this.categoryID = categoryID;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public int getProductID(){
        return productID;
    }

    public int getCategoryID(){
        return categoryID;
    }

    public String getProductName(){
        return productName;
    }

    public int getProductPrice(){
        return productPrice;
    }

}