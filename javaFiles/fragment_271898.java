public class StringEqualsSecondHalf {

public static void main(String[] args) {
    String sFB="String";
    if(sFB.length()%2!=0){
        System.out.println("Its not same");
    }
    else{
        String firstHalf=sFB.substring(0,sFB.length()/2);
        System.out.println("First Half "+firstHalf);
        String secondHalf=sFB.substring(sFB.length()/2,sFB.length());
        System.out.println("Second Half "+secondHalf);
        if(firstHalf.equals(secondHalf)){
            System.out.println("They are same");
        }
        else{
            System.out.println("They are not same");
        }
    }

}