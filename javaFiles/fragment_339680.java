public class TestSample {
        public static void main(String[] args) { 

        int a = Integer.parseInt(args[0]); // 1
        int b = Integer.parseInt(args[1]); // 6
        double random1, random2;

        if(a < b) {
            random1 = (b-a)*Math.random() + a;
            random2 = (b-a)*Math.random() + a;
        }
        else {
            random1 = (a-b)*Math.random() + b;
            random2 = (a-b)*Math.random() + b;
        }
        double sum = random1 + random2;
        System.out.println("Random Number" +(int)sum);
    }
}