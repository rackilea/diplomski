import java.util.*;

public class LongNumbers {

    private List<Integer> [] theLists;

    public LongNumbers(){
        this.theLists = new LinkedList[11];
        for (int i=0; i<11; i++)
            this.theLists[i]= new LinkedList<>();
    }

    public void add(int location, int digit)
    {
        //add digit at head of LinkedList given by location
        theLists[location].add(digit);
    }

    public void remove(int location)
    {
        //remove a digit from LinkedList given by location
        for (int i=0; i<theLists[location].size(); i++){
            theLists[location].remove(i);
            theLists[location].add(i,0);
        }
    }

    public boolean isEmpty(int location)
    {
        //check for an empty LinkedList given by location
        return theLists[location].isEmpty();
    }

    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);

        //local variables
        String number;
        boolean userWantsToQuit = false;
        LongNumbers lists = new LongNumbers();
        int currArrayLocation = 0;
        int currDigit = 0;
        int maxLength = 0;
        int numsEntered = 0;
        int finalDigit = 0;
        int carryDigit = 0;
        char[] digits;

        //get data
        do{
            System.out.println("Enter a number, or enter -1 to escape.");
            number = kb.nextLine();

            if(number.equals("-1"))
                userWantsToQuit = true;
            else {
                numsEntered++;
                if (number.length()> maxLength) 
                    maxLength = number.length();
                digits = new char[number.length()]; 
                for (int i = 0; i < number.length(); i++){
                    digits[i] = number.charAt(i);
                    currDigit = digits[i]-48;
                    lists.add(currArrayLocation, currDigit);}
            } 
            currArrayLocation++;

        } while (!userWantsToQuit && currArrayLocation < 9 );
        //if the linkedLists are full
        if (currArrayLocation == 9)
            System.out.println("The max amount of numbers have been entered.");
        bufferWithLeadingZeroes(lists.theLists,maxLength);
        //to add numbers into final linked list
        for (int i = 0; i < maxLength; i++){
            for (currArrayLocation = 0; currArrayLocation < numsEntered; currArrayLocation++){
                if (lists.theLists[currArrayLocation]== null){
                    lists.remove(0);}
                //currDigit = 0;
                else{
                    currDigit = lists.theLists[currArrayLocation].get(i);
                    int tempDigit = currDigit;
                    System.out.println("temp: " + tempDigit); //test line
                    finalDigit += tempDigit;
                    System.out.println(finalDigit); //test line
                }
            }
            if (finalDigit > 9){
                i++;
                int newDigit = lists.theLists[10].get(i-1) + (finalDigit/10);
                lists.theLists[10].remove(i-1);
                lists.theLists[10].add(i-1,newDigit);
                finalDigit %= 10;
                for (int j=(i-1); j>=0; j--){
                    if (lists.theLists[10].get(j) > 9){
                        if (j == 0){
                            lists.theLists[10].add(j,0);
                            j++;
                            i++;
                        }
                        newDigit = lists.theLists[10].get(j-1) + 1;
                        lists.theLists[10].remove(j-1);
                        lists.theLists[10].add(j-1,newDigit);
                        newDigit = lists.theLists[10].get(j) % 10;
                        lists.theLists[10].remove(j);
                        lists.theLists[10].add(j,newDigit);
                    }
                }
                i--;
            }
            lists.add(10, finalDigit);
            finalDigit = 0;
        }
        //print the sum
        if (lists.theLists[10] != null){
            System.out.print("Sum: ");
            for (int i = 0; i < lists.theLists[10].size() ; i++){
                System.out.print(lists.theLists[10].get(i));
            }
        }
    }//end main

    public static void bufferWithLeadingZeroes(List<Integer>[] theLists, int maxLength){
        for (int i=0; i<10; i++){
            int howManyToAdd = maxLength - theLists[i].size();
            for (int j=0; j<howManyToAdd; j++){
                theLists[i].add(0,0);
            }
        }
        theLists[10].add(0,0);
    }

}//end class