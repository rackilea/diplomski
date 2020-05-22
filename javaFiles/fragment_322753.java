import java.text.*;

interface Fmt{
    public String f(int x);
}

class Test{

    static NumberFormat formatter = new DecimalFormat("00");

    static Fmt f1 = new Fmt(){
        public String f(int x){ return ((x<10)?"0":"") + x; }
        public String toString(){return "f1";}
    };

    static Fmt f2 = new Fmt(){
        public String f(int x){ return String.format("%02d", x); }
        public String toString(){return "f2";}
    };

    static Fmt f3 = new Fmt(){
        public String f(int x){ return formatter.format(x); }
        public String toString(){return "f3";}
    };

    public static void main(String[]args){

        Fmt[] fmts = new Fmt[]{f1, f2, f3, f3, f2, f1};

        for (int x : new int[]{7, 42, 99}){

            String s0 = null;
            for (Fmt fmt : fmts)
                if (s0==null)
                    s0 = fmt.f(x);
                else
                    if (!fmt.f(x).equals(s0))
                        System.exit(1);

            System.out.printf("%02d\n", x);

            for (Fmt fmt : fmts){
                String s = null;
                int count = 0;
                System.gc();
                long t0 = System.nanoTime();
                for (int i=0; i<100000; i++){
                    count += fmt.f(x).length();
                }
                long t1 = System.nanoTime();

                System.out.printf("    %s:%8.2fms, count=%d\n",
                    fmt, (t1-t0)/1000000.0, count);
            }

        }
    }

}