import java.util.*;
import java.io.*;
public class ProductInfoDwnld{
    static String abc;
    public static void addProductToCart(String a_CartId, String a_productId, String a_desc, String a_price){
        BufferedWriter bw = null;
        try{
            File yourFile = new File(a_CartId);
            // Check if yourFile exists
            if(!yourFile.exists()) {
                yourFile.createNewFile(); // Create a new yourFile if it does not exist
            }

                    // Note you had an else block here:
                    // If the file didn't exist you only would create it
                    //  and not write any data to it.
                    // If the file exists you'd write data to it.
                    // I removed the else block

            try {
                FileWriter fileWrite = new FileWriter(yourFile,true);
                fileWrite.write(a_productId + " " + a_desc + " " + a_price); // write(String str);
                fileWrite.flush();
                fileWrite.close();
            }catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }catch(Exception e){
            System.out.println("Error");
        }
    }
    public static void main(String[] args){
        String CartID = "001.txt";
        String productId="001", Desc = "Laptop", price="20000Rs";
        addProductToCart(CartID,productId,Desc,price);
    }
}