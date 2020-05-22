public class Conditions {

    public static boolean isTrue(){
        System.out.println("Is True");
        return true;
    }

    public static boolean isFalse(){
        System.out.println("Is False");
        return false;
    }

    public static void main(String[] args) {
        if(isFalse() || isTrue() || isTrue()){
            System.out.println("Condition passes");
        }
    }
}