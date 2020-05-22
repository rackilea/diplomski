/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoverflow;

import java.util.Random;

/**
 *
 * @author Ashish Tyagi
 */
public class Stackoverflow {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //String ascii = "abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ!#$%&'()*+.-/:;<=>?@[]^_{|}~";
        String ascii="abc";
        for(int i=1;i<=ascii.length();i++){
        combin(ascii.substring(0, i), new StringBuffer(), i);
        combin(ascii.substring(i), new StringBuffer(), i);
    }
  }


 public static void combin(String input,StringBuffer output,int depth){
      if (depth == 0) {
            System.out.println(output);
        } else {
            for (int i = 0; i < input.length(); i++) {
                output.append(input.charAt(i));
                combin(input, output,depth - 1);
                output.deleteCharAt(output.length() - 1);
            }
        }    
 }
}