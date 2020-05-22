public class Test {
    public static void main(String[] args) {



        double roundedUp=Math.ceil(4.1);

        System.out.println(shouldBeRoundedUp(2.2,0.5)); 
        System.out.println(shouldBeRoundedUp(2.7,0.5)); 

    }

    public static boolean shouldBeRoundedUp(double value, double roundIfAbove){
        double decimalPart=value%1; //this is the modulus operator, or remainder operator 
        if (decimalPart>roundIfAbove){
            return true;
        }else{
            return false;
        }

    }
}