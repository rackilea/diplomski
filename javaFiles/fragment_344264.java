package split;

public class Main {

    public static void main(String[] args){

        String mString = "<12,3>,<4,5>,<23,5>,<33,56>"; 
        mString = mString.replace("<", ""); 
        mString = mString.replace(">", ""); 
        String[] stringArray = mString.split(","); 

        int[] intArray = new int[stringArray.length];
        int index = 0; 
        for(String mS : stringArray){
            intArray[index] = Integer.parseInt(mS); 
            index++;
        }

        for(int i : intArray){
            System.out.println(i); 
        }
    }
}