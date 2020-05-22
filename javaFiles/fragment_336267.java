public class ATM {
    public static void main(String[] args) {
        System.out.print("Please enter your pin");
        Scanner sc = new Scanner(System.in);
        Keypad K=new Keypad();
        K.mypin(sc.nextInt());
    }
}

public class Keypad{
    public void mypin(int pin) {
        System.out.print(pin);  
    }
}