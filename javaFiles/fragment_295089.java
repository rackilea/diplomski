import java.util.*;

Random generator = new Random();
for(int i = 0; i < 10; i++) {
    int random = generator.nextInt(24) + 8;
    System.out.println(Math.pow(2, random));
}