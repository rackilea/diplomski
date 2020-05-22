import java.io.*;
 public class GetAnswers {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new 

FileReader("GetAnswers.txt")))
        {
            String [][] answers;
            answers = new String[10][4];
            String line;
            int i = 0;
            String [] temp = new String [40];
            while ((line = br.readLine()) != null) {
              temp[i++] = line;
            }

            for(int j=0; j<temp.length; j++){
                  answers[j/4][j%4] = temp[j];
                   System.out.println(answers[j/4][j%4]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
}
}