import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FromFile {

public static void main(String args[]) throws Exception {
    Scanner s = new Scanner(new File("D:/A1.txt"));
    int testCaseCount = Integer.parseInt(s.next());

    for (int i = 0; i < testCaseCount; i++){
        int Avail = Integer.parseInt(s.next());

        int size=Integer.parseInt(s.next());

        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int j=0;j<size;j++)
        {

        list.add(s.nextInt());
        }

        FileWriter fw=new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw=new BufferedWriter(fw);

        for(int k=0;k<list.size()-1;k++){
            for(int j=k+1; j<=list.size()-1;j++){
                    int sum=list.get(k)+list.get(j);

                    if(sum==Avail){
                    System.out.println((k+1)+", "+(j+1));
                    File file=new File("D:/A2.txt");
                    if(!file.exists()){
                        file.createNewFile();
                    }

                    bw.write("Case:"+i+"-"+(k+1)+", "+(j+1)+" Available is "+Avail+" Values are "+list.get(k)+","+ list.get(j));


                    }

            }
            }       

         bw.close();
        }
    s.close();

}
}