import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class Test {

    public static void main(String []args) throws Exception{

        double fizzes = 0;
        double buzzes = 0;
        double fizzbuzzes = 0;
        double normals = 0;
        double iterations = 1000000;


        BufferedWriter sout = new BufferedWriter(new OutputStreamWriter(new
                FileOutputStream(java.io.FileDescriptor.out),"ASCII"), 1024);

        for (int x = 0; x < iterations; x++) {


            int index = 0;
            StringBuilder output = new StringBuilder();

            if (x % 3 == 0) {

                output.append("Fizz");
                index = 1;
            }

            if (x % 5 == 0) {

                output.append("Buzz");

                index = index + 2;
            }
            if (output.length()==0) { //x%5!=0 && x%3!=0
                sout.write(String.valueOf(x));
                sout.write("\r\n");
                normals++;
            }
            else {
                sout.write(output.toString());
                sout.write("\r\n");
            }


            if (index == 3) {
                fizzbuzzes++;

            }
            else if (index == 2) {
                buzzes++;
            }
            else if (index == 1) {
                fizzes++;
            }


        }

        System.out.println("Normals " + (normals/iterations*100) + "%"); //percent
        System.out.println("Fizzes " + (fizzes/iterations*100)+ "%");
        System.out.println("Buzzes " + (buzzes/iterations*100)+ "%");
        System.out.println("FizzBuzzes " +(fizzbuzzes/iterations*100)+ "%");


    }
}