public class Main {

    int counter;

    public static void main(String[] args) throws InterruptedException {
        int one = 1;

        counter = 0;

        while (one<100){
            Thread.sleep(1000);
            counter += 1;

            one++;
        }
    }

    public int getCounter() {
        return counter;
    }
}

public class Function {

    public static int move (int result, Main main){

        result = 1 + main.getCounter();      
        return result;
    }
}