public class MyApp {  
    public static void main(String[] args) {  

        if (args.length == 0) {  
            try {  
                // re-launch the app itselft with VM option passed  
                Runtime.getRuntime().exec(new String[] {"java", "-Dcom.sun.javafx.isEmbedded=true", "-Dcom.sun.javafx.virtualKeyboard=\"javafx\"", "-Dcom.sun.javafx.touch=true", "-jar", "myApp.jar"});  
            } catch (IOException ioe) {  
                ioe.printStackTrace();  
            }  
            System.exit(0);  
        }  

        // Run the main program with the VM option set  
        //...  
        //...  
    }  
}