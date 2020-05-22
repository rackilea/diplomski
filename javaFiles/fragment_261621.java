import java.io.*;
public class cmd {
    public static void  
        main(String[] argv){
        String line;
        String[] cmd = {"bash","-c","ls"};
        System.out.println("Hello, world!\n");
        try {
            Process p = Runtime.getRuntime().exec(cmd);
            BufferedReader input =
                new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            input.close();
        } catch (Exception e) {
        }
        return ;
    }
}