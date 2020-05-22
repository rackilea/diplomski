import java.util.Scanner;

class T1 
{
    public static Scanner obj = new Scanner(System.in);
    public static void main(String args[]) {
        add s = new add();
        try{
            s.start();
            s.join();
        }catch(Exception ex){}
    }
}

class num1 extends Thread {
    int n1;
    public void run() {
        System.out.println("enter first no");
        n1 = T1.obj.nextInt();
        System.out.print("In num1 is " + n1 + "\n");
    }
}

class num2  extends Thread {
    int n2;
    public void run() {
        System.out.println("enter second no");
        n2 = T1.obj.nextInt();
        System.out.print("In num2 is " + n2 + "\n");
    }
}

class add extends Thread {
    public void run() {
        num1 o = new num1();
        num2 t = new num2();
        o.start();
        t.start();
        try {
            o.join();
            t.join();
        }catch(Exception ex){}

        System.out.print("The sum is " + (o.n1 + t.n2) + "\n");
    }
}