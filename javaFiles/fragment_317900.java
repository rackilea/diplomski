import javax.swing.JOptionPane;

public class Maths {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String num1 = JOptionPane.showInputDialog("Num1: ");
        String num2 = JOptionPane.showInputDialog("Num2: ");
        int num11 = Integer.parseInt(num1);
        int num22 = Integer.parseInt(num2);

        calculationThread T1 = new calculationThread("Addition");
        T1.getNumber(num11, num22);
        T1.start();

        calculationThread T2 = new calculationThread("Subtraction");
        T2.getNumber(num11, num22);
        T2.start();

        calculationThread T3 = new calculationThread("Multiplication");
        T3.getNumber(num11, num22);
        T3.start();

        calculationThread T4 = new calculationThread("Division");
        T4.getNumber(num11, num22);
        T4.start();
    }
}

class calculationThread extends Thread{
    private Thread t;
    private String maths;
    private int a;
    private int b;
    private int resultplus = 0;
    private int resultminus = 0;
    private int resulttimes = 0;
    private int resultdivide = 0;

    public void getNumber(int num1, int num2){
        a = num1;
        b = num2;
    }

    calculationThread(String answer){
        maths = answer;
    }

    public void start(){
        System.out.println("Starting calculation of " + maths + "\n");
        if(t == null){
            t = new Thread(this, maths);
            t.start();
        }
    }

    public void run(){
        try {
            for (int x=0; x<=3 ; x++){
                if(maths.equals("Addition")){
                System.out.println("Calculating: " + maths + " of " + a + 
                        " + "+ b + " = " + resultplus + "\n");
                Thread.sleep(3000);
                resultplus = a + b;
                }
                else if(maths.equals("Subtraction")){
                    System.out.println("Calculating: " + maths + " of " + a + 
                            " - "+ b + " = " + resultminus + "\n");
                    Thread.sleep(3000);
                    resultminus = a - b;
                }
                else if(maths.equals("Multiplication")){
                    System.out.println("Calculating: " + maths + " of " + a + 
                            " * "+ b + " = " + resulttimes + "\n");
                    Thread.sleep(3000);
                    resulttimes = a * b;
                }   
                else if(maths.equals("Division")){
                    System.out.println("Calculating: " + maths + " of " + a + 
                            " / "+ b + " = " + resultdivide + "\n");
                    Thread.sleep(3000);
                    resultdivide = a / b;
                }   
            }   
        }
        catch (InterruptedException e){
            System.out.println("Math function failed");
        }
        finally{
            if(maths.equals("Addition")){
                System.out.println("Addition completed.");
            }
            else if(maths.equals("Subtraction")){
                System.out.println("Subtraction completed.");
            }
            else if(maths.equals("Multiplication")){
                System.out.println("Multiplication completed.");
            }
            else if(maths.equals("Division")){
                System.out.println("Division completed.");
            }           
        }
    }
}