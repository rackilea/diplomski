public class HelloWorld{

     public static void main(String []args){
        double B1 = 2560;
        double B2 = 1080;
        double T1 = 2561;
        double T2 = 1081;
        double calD = 0;
        double calE = 0;
        double d = 0;
        while (T1 < 4000){
            T2 = 1081;
            while (T2 < 2200) {
                calD = B1*T2;
                calE = B2*T1;
                d = calD - calE;
                if (d == 0){                    
                    System.out.println(T1+ " X "+ T2 + " Result: " + d);
                    T2 = T2+1;                  
                }
                else {                  
                    T2 = T2+1;
                }
            }
            T1 += 1;
        }
    }
}