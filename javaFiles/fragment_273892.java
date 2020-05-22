import java.io.*;

public class UserPass {
    public static void main(String[] args) {
        FileReader fr;
        BufferedReader br;
        PrintWriter pw;
        String[] pass;
        String[] user;
        String tmp;
        int FileContentCount;
        // Number Of users used for initialize the string arrays .
        int noOfUsers = 3;

        pass = new String[noOfUsers];
        user = new String[noOfUsers];

        // Reading User Name From File 
        String UserFileName = "userdetails.txt";

        try {
            fr = new FileReader(UserFileName);
            br = new BufferedReader(fr);
            // 
             FileContentCount= 0;
            while ((tmp = br.readLine()) != null) {

                user[FileContentCount] = tmp;

                tmp = br.readLine();

                pass[FileContentCount] = tmp;
                FileContentCount++;

            }
            br.close();
            fr.close();

            // Printing First Username  and Pass This canbe used for Your use
            System.out.println(user[0] + " : " + pass[0]);

            // Deleting File Contents Actualy writing without those contents.
           pw = new PrintWriter(UserFileName);
            int count = 1;// Avoiding the First User Details
            while (count < FileContentCount) {
                    pw.write(user[count] + "\n");
                    pw.write(pass[count] + "\n");
                    count++;
            }
            pw.flush();
            pw.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}