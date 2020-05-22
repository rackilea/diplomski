public class Tarot {

public static int rValue (){

int i =0;

    do {
    int n = (int) (Math.random()*36 );
        if (n%5 ==0){
        int r =n;
        i++;
        }       
    }while(i<1);
    return r;   
  }
}