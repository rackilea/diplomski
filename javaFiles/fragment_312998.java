public class Teste4 {

public static void main(String args[]) {

    int x = 50;
    int y = 50;
    int i = 0;
    int j = 1;
    int n = 0;

    System.out.print("Even numbers between 50 and 100: ");
    while((i < x) || (j < y)) {
        if(i < x){
            System.out.print(i + x + ", ");
            i += 2;
            continue;
        }else if(i == x){
            System.out.println("100");
            i++;
        }

        if(j == 1){
            System.out.print("\nOdd numbers between 50 and 100: ");
        }

        System.out.print(j + y + ", ");
        j += 2;
    }       
  }
}