/*
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class DupRemove {
public static void main(String...arg){ 
  double val[]={1,4.3,5,2,4,4,4,6.5,2,2,2,2,2,3.5,3.7,4,7,8,9};
  for(int i=0;i<val.length;i++){
    add(val[i]);
  }
  Collections.sort(list);
  System.out.println(list);
 }
static List<Double> list=new ArrayList<>();
public static void add(double d){
  if(!list.contains(d)){list.add(d);}
}
}
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class PointStatue {
/*private static List<Double> col1 = new ArrayList<Double>(); 
private static List<Double> col2 = new ArrayList<Double>();
private static List<Double> col3 = new ArrayList<Double>();
private static List<Double> col4 = new ArrayList<Double>();
private static List<Double> col5 = new ArrayList<Double>();
private static List<Double> col6 = new ArrayList<Double>();
private static List<Double> col7 = new ArrayList<Double>();
private static List<Double> col8 = new ArrayList<Double>();*/
//private static List<Double> list=new ArrayList<Double>();
private static ArrayList<List<Double>> rows=new ArrayList<List<Double>>();

private static List<Double> numbers = new ArrayList<Double>();
private static void okuDiziyeKoy(String path,ArrayList<String> arr) throws Exception{
  BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(path)));
  //skip the first line
  br.readLine();
  String g;
  while((g=br.readLine())!=null){
    arr.add(g);
  }
}
public static void main(String[] args) throws Exception {
    ArrayList<String> puan = new ArrayList<String>();
    okuDiziyeKoy("C:/deneme/HW.txt", puan);
    //   puan = okuDiziyeKoy("C:\\deneme\\HW.txt");
    System.out.format("%d kayıt okundu.%n", puan.size());
    Double doubleValue;
    for (int j = 0; j < 6; j++) {
      rows.add(new ArrayList<Double>());
    }
    for (int j = 0; j < puan.size(); j++) {
        String point = puan.get(j);
        //split data(line) by }{
        String[] edit = point.split("[}][{]");
        for(int l=3;l<edit.length-1;l++){
          //parsing String as double
          doubleValue=Double.parseDouble(edit[l]);
          //check if double value is not exist then add it to list
          if(!numbers.contains(doubleValue)){
          numbers.add(doubleValue);
          }
          if(!rows.get(l-3).contains(doubleValue)){
            rows.get(l-3).add(doubleValue);
          }
        }
       /* for (String s : edit) {

            String a = s.replaceAll("[\\}\\-\\>\\>\\]\\[\\#\\*\\{]+", "");
            String b = a.replaceAll("[\\.]+", ",");
            Scanner scanner = new Scanner(b);

            while (scanner.hasNext()) {

                if (scanner.hasNextDouble()) {

                    doubleValue = scanner.nextDouble();
                    if(!numbers.contains(doubleValue)){
                    numbers.add(doubleValue);
                    }
                    // System.out.println(Arrays.deepToString(numbers.toArray()));

                }// if scan end

                else {

                    //if it is string comes value here
                    String stringValue = scanner.next();

                }// if scan end

            }// while end

        }// for string s

    }// for j end*/

        }
    Collections.sort(numbers);
    System.out.println("Unique values(in all rows): ");
    for(Double d :numbers){
        System.out.print(d+" ");
      }
    System.out.println();
    /*int col=1;
    for(int i=0;i<numbers.size();i++)
    {

        Double rowValue = numbers.get(i);

        switch(col)
        {
        case 1:
            col1.add(rowValue);

            col++;
            break;
        case 2:
            col2.add(rowValue);

            col++;
            break;
        case 3:
            col3.add(rowValue);

            col++;
            break;
        case 4:
            col4.add(rowValue);

            col++;
            break;
        case 5:
            col5.add(rowValue);

            col++;
            break;
        case 6:
            col6.add(rowValue);

            col = 1;
            break;

        }//switch end

    }//for i end*/
   /* Collections.sort(col1);
    Collections.sort(col2);
    Collections.sort(col3);
    Collections.sort(col4);
    Collections.sort(col5);
    Collections.sort(col6);*/
    /*System.out.println("kolon1 "+col1);
    System.out.println("kolon2 "+col2);
    System.out.println("kolon3 "+col3);
    System.out.println("kolon4 "+col4);
    System.out.println("kolon5 "+col5);
    System.out.println("kolon6 "+col6);*/
    //sorting each row
    for(int i=0;i<rows.size();i++){
      Collections.sort(rows.get(i));
    }
    //showing each row(array)
    for(int i=0;i<rows.size();i++){
      System.out.println("kolon"+(i+1)+": "+rows.get(i));
    }

}// main end  
}