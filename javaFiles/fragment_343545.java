public class Brands {

    private String mBrandName;
    private String colour;

    //constructor with 2 arguments, brand name and colour
    public Brands(String brandName, String colour){
        mBrandName = brandName;
        this.colour = colour;
    }

    public String getBrand(){
        return mBrandName;
    }

    public String getColour(){ //getter of colour
        return colour;
    }
}