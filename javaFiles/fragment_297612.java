import java.io.*;

public class InputStreamReadDemo {


    private void readByte() throws IOException {
        System.out.print("Enter the byte of data that you want to be read: ");        
        int a = System.in.read();
        System.out.println("The first byte of data that you inputted corresponds to the binary value "+Integer.toBinaryString(a)+" and to the integer value "+a+".");
        System.in.skip(System.in.available());
    }
    private void readLine() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a line of text: ");
        String res = br.readLine();
        System.out.println("You entered the following line of text: "+res);
        // ... and tried writing br.close();
        // but that messes things up since the input stream gets closed and reset..
    }

    public static void main(String[] args) throws IOException {
        InputStreamReadDemo isrd = new InputStreamReadDemo();
        isrd.readByte();                                                // method 1
        isrd.readLine();                                                // method 2
    }
}