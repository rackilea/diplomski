public class Main {

public static void main(String[] args) {
for(int input = 11; input <= 99; input += 2){
    boolean found = false;
    for(int x = 2; x < (int)Math.sqrt(input) + 1; x++){
        if(input%x == 0){
            found = true;
            break;
        }

    }
    if(!found) {
            System.out.println(input);
    }
}
}
}