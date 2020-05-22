import java.io.*;
    import java.util.*;
    import java.util.stream.Collectors;
    public class Sample {
        public static void main(String args[] ) throws Exception {

            Scanner scan = new Scanner(System.in);
            int nValue = scan.nextInt();
            if(nValue<1 || nValue>100){
                System.out.println("Array Value cannot be less than 1 or greater than 100");
            }
            int[] inputCredits = new int[nValue];
            for( int i=0 ; i < nValue ; i++){
                inputCredits[i]=scan.nextInt();
                if(inputCredits[i]<1 || inputCredits[i]>5){
                    System.out.println("Credit Value cannot be less than 1 or greater than 5");
                }
            }
            List<Integer> list1 = Arrays.stream(inputCredits).boxed().collect(Collectors.toList());
            List<Integer> list2 = Arrays.asList(5,6,7,8,9,10);
//checked for basic constraints up till this point
//Next what we multiply all the inputted Credits with the possible grades and 
// store in the list where x input Credits will produce a list of x*6 entries 
// where first six entries are the possibilities for the first Credit, next 6 
// entries for the 2nd credit and so on, having this knowledge we loop through // the list to get all the possible scores 
            List<Integer> permutedList = list1.stream().flatMap(i -> list2.stream().map(j -> i*j)).collect(Collectors.toList());

            List<Integer> listForDistinctSet= new ArrayList<Integer>();
            for(int i=0; i<6 ; i++){
                listForDistinctSet.add(permutedList.get(i));
            }
            Set<Integer> distinctSet = new HashSet<Integer>();

            for(int j=6,k=j+6;k<=permutedList.size();j=k,k=k+6){
                Set<Integer> newSet = new HashSet<Integer>();
                for(int i=0; i<listForDistinctSet.size(); i++){

                    for(; j<k ; j++){
                        int sum = listForDistinctSet.get(i) + permutedList.get(j);
                        newSet.add(sum);
                    }
                    j=k-6;
                }
                distinctSet=newSet;
                listForDistinctSet = new ArrayList<>(distinctSet);
            }
            System.out.println(distinctSet.size());

       }
    }