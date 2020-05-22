import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.io.IOException;
import rediff.inecom.catalog.product.CSVAPI;

class MyFirstClass{
    public void myFunction() {
        CSVAPI cvsapi = new CSVAPI();
        System.out.println(cvsapi);
        String output = cvsapi.UpdateCSVAPI(12345,"myfile.csv");
        System.out.println(output);

        System.out.println("Success!");
    }

    public static void main(String args[]){
        new MyFirstClass().myFunction();
    }
}