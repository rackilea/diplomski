public class OddSum1 {
public OddSum1() {
}
public static void main(String[] args) {
int OddLimit = Integer.parseInt(args[0]);
int sum = 0;
for (int i = 1; i <= OddLimit; i += 2)
sum += i;
System.out.println("The sum of odd numbers from 1 to " + OddLimit + " is " + sum);
}    
}