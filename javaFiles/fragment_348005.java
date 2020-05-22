public class MyClass {
public static void main(String args[]) {
    int p[] = new int[3];
    p[0] = 10;//%
    p[1] = 20;//%
    p[2] = 70;//%

    int value[] = new int[3];
    value[0] = 1;//fill 1 to first 10%
    value[1] = 2;//fill 2 to first 20%
    value[2] = 3;//fill 3 to first 70%

    int size = 100;
    int a[] = new int[size];

    int count = 0;
    for(int i=0;i<3;i++){
        for(int j=0;j<(size*p[i])/100;j++){
            a[count] = value[i];
            ++count;
        }

    }
    for(int i=0;i<size;i++){
        System.out.println(a[i]);
    }
}