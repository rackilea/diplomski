import java.util.Scanner; 

public class DemoTest1 {
    static Demo addDemo(Demo obj1, Demo obj2) {
        return new Demo(obj1.getValue1() + obj2.getValue1(), 
                obj1.getValue2() + obj2.getValue2());
    }

    static void incrDemo(Demo obj) {
        obj.setValues(obj.getValue1() + 5, obj.getValue2() + 5);
    }

    public static void main(String args[]) {
        Demo item = new Demo(0, 0);

        System.out.println("\nPlease enter 2 numbers: ");
        Scanner input = new Scanner(System.in);
        double val1 = input.nextDouble();
        double val2 = input.nextDouble();
        item.setValues(val1, val2);

        System.out.println("\nThe average of the two values entered is: " 
                + item.getAverage());

        Demo obj1 = new Demo(5, 7);
        Demo obj2 = new Demo(14, 9);

        Demo objR = addDemo(obj1, obj2);

        incrDemo(obj1);

        System.out.printf("\nobjR has the following values. val1: %.2f\tval2: %.2f", 
                objR.getValue1(), objR.getValue2());
        System.out.printf("\nobj1 has the following values. val1: %.2f\tval2: %.2f", 
                obj1.getValue1(), obj1.getValue2());
    }
}