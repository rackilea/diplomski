import java.util.Scanner;
public class Pascal {

    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        System.out.print("plese enter height of pascal tringle :");
        int heightchk = 0, height = sc.nextInt();
        if (height > 0) {
            MyArray pascalArray = new MyArray();
            pascalArray.setLength(height * 2 - 1);
            pascalArray.IntilizeA(pascalArray.a);
            if (height == 1) {
                pascalArray.printArray(pascalArray.a);
            } else {
                while (heightchk < height) {
                    pascalArray.printArray(pascalArray.a);
                    heightchk += 1;
                    if (heightchk < height) {
                        pascalArray.reSet(pascalArray.b);
                        pascalArray.setElements(pascalArray.a, pascalArray.b);

                        pascalArray.printArray(pascalArray.b);
                        heightchk += 1;
                        if (heightchk < height) {
                            pascalArray.reSet(pascalArray.a);
                            pascalArray.setElements(pascalArray.b, pascalArray.a);
                        }
                    }
                }
            }
        } else {
            System.out.println("Can't Drow pascal Tringle of this Height");
        }

        sc.close();
    }
}

class MyArray {
    String[] a, b;
    void IntilizeA(String[] array) {
        array[(array.length - 1) / 2] = "\t1";
    }
    void setLength(int length) {
        a = new String[length];
        b = new String[length];
        for (int i = 0; i < a.length; i++) {
            a[i] = "\t";
            b[i] = "\t";
        }
    }
    void reSet(String[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = "\t";
        }
    }
    void printArray(String[] array) {
        for (String element : array) {
            System.out.print(element);
        }
        System.out.println();

    }
    void setElements(String[] from, String[] to) {
        for (int i = 0; i < from.length; i++) {
            if (from[i] != "\t") {
                if (to[i - 1] == "\t") {
                    to[i - 1] = "0";
                }
                if (to[i + 1] == "\t") {
                    to[i + 1] = "0";
                }
                to[i - 1] = "\t"+String.valueOf(Integer.valueOf(to[i - 1].trim()) + Integer.valueOf(from[i].trim()));
                to[i + 1] = "\t"+String.valueOf(Integer.valueOf(to[i + 1].trim()) + Integer.valueOf(from[i].trim()));
            }
        }
    }
}