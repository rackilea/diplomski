import java.util.ArrayList;
import java.util.Scanner;


public class Digrams{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Insert The Sentence");
        String []sentence =  in.nextLine().split(" "); // split the input according to the spaces and put them in array

        //get all digrams
        ArrayList<String> allDigrams = new ArrayList<String>(); // ArrayList to contain all possible digrams
        for(int i=0; i<sentence.length; i++){ // do that for every word     
            for(int j=0; j<sentence[i].length(); j++){ // cycle through each char at each index in the sentence array
                String oneDigram= "";
                if(j<sentence[i].length()-1){
                    oneDigram += sentence[i].charAt(j); // append the char and the following char
                    oneDigram += sentence[i].charAt(j+1);
                    allDigrams.add(oneDigram); // add the one diagram to the ArrayList
                }
            }
        }

        // isolate digrams and get corresponding frequencies
        ArrayList<Integer> frequency = new ArrayList<Integer>(); // for frequencies
        ArrayList<String>  digrams = new ArrayList<String>(); //for digrams
        int freqIndex=0;
        while(allDigrams.size()>0){ 
            frequency.add(freqIndex,0);
            for(int j=0; j<allDigrams.size(); j++){ // compare each UNIQUE digram with the rest of the digrams to find repetition
                if(allDigrams.get(0).equalsIgnoreCase(allDigrams.get(j))){
                    frequency.set(freqIndex, frequency.get(freqIndex)+1); // increment frequency    
                }
            }
            String dig = allDigrams.get(0); // record the digram temporarily
            while(allDigrams.contains(dig)){ // now remove all repetition from the allDigrams ArrayList
                allDigrams.remove(dig);
            }
            digrams.add(dig); // add the UNIQUE digram
            freqIndex++; // move to next index for the following digram 
        }


        // sort result in descending order
        // compare the frequency , if equal -> the first char of digram, if equal -> the second char of digram
        // and move frequencies and digrams at every index in each ArrayList accordingly
        for (int i = 0 ; i < frequency.size(); i++){
            for (int j = 0 ; j < frequency.size() - i - 1; j++){
                if (frequency.get(j) < frequency.get(j+1) || 
                      ((frequency.get(j) == frequency.get(j+1)) && (digrams.get(j).charAt(0) > digrams.get(j+1).charAt(0))) ||
                        ((digrams.get(j).charAt(0) == digrams.get(j+1).charAt(0)) && (digrams.get(j).charAt(1) > digrams.get(j+1).charAt(1)))){ 
                    int swap  = frequency.get(j);
                    String swapS = digrams.get(j);
                    frequency.set(j, frequency.get(j+1));
                    frequency.set(j+1, swap);
                    digrams.set(j, digrams.get(j+1));
                    digrams.set(j+1, swapS);
                }
            }
        }


         //final result
         String sortedResult="";
         for(int i=0; i<frequency.size(); i++){
             sortedResult+=digrams.get(i) + ":" + frequency.get(i) + " ";
         }

         System.out.println(sortedResult);

    }

}