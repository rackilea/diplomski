import java.io.*;
public class Example{
public static void main(String args[]) {
    try {
        FileOutputStream fos = new FileOutputStream("1.dat");
        DataOutputStream dos = new DataOutputStream(fos);

        for (int i = 0; i < 100; i++) {
            dos.writeInt(i);
        }
        dos.close();

        FileOutputStream fos1 = new FileOutputStream("2.dat");
        DataOutputStream dos1 = new DataOutputStream(fos1);

        for (int i = 100; i < 200; i++) {
            dos1.writeInt(i);
        }
        dos1.close();

        Exampless.createArray(0); //static method call to set the static arr variable
        Exampless ex1 = new Exampless("1.dat");
        Exampless ex2 = new Exampless("2.dat");
        Thread t1 = new Thread(ex1);
        Thread t2 = new Thread(ex2);
        t1.start(); //calls the run method in ex1 in a new thread
        t2.start();

    } catch (Exception e) {
        System.err.println("Error: " + e.getMessage());
    }
}
}

class Exampless implements Runnable {

public static int[] arr = new int[100];
public String _name;

public Exampless(String name) {
    this._name = name;
}

static void createArray(int z) {
    for (int i = z; i < z + 100; i++) {
        arr[i - z] = i;
    }
}

@Override
public void run() {
    try {
        int cnt = 0;
        FileInputStream fin = new FileInputStream(_name);
        DataInputStream din = new DataInputStream(fin);
        for (int i = 0; i < 100; i++) {
            int c = din.readInt();
            if (c == arr[i]) {
                cnt++;
            }
        }
        System.out.println("File name: " + _name + " No. of Matches: " + cnt);
    } catch (Exception e) {
        System.err.println("Error: " + e.getMessage());
    }
}

}