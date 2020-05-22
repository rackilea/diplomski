public class Main {
public static void main(String[] args){
    char t[] = {'a', 'b', 'c'};
    char x[] = {'e', 'a', 'b', 'x', 'c', 'a', 'b', 'c'};

    int count = 0;
    while(count != x.length){
        if(x[count] != 'a'){
            count++;
        }else{
            if(x[count + 1] != 'b'){
                count++;
            }else{
                if(x[count + 2] != 'c'){
                    count++;
                }else{
                    System.out.println(count);
                    System.exit(0);
                }
            }
        }
    }
}