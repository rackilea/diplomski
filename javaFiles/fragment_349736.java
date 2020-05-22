$cat UsingC.java  UsingS.java  
public class UsingC { 
    public static void main( String [] args ) { 
        String someString  = "";
        String anotherString = "";

        int i = 0;
        while( i++ < 10000000 ) { 
            String a = someString + '.' + anotherString;
        }
    }
}
public class UsingS{ 
    public static void main( String [] args ) { 
        String someString  = "";
        String anotherString = "";

        int i = 0;
        while( i++ < 10000000 ) { 
            String a = someString + "." + anotherString;
        }
    }
}
$for i in 1 2 3 4 5 ; do time java UsingC; done

real    0m1.643s
user    0m1.424s
sys 0m0.108s

real    0m1.670s
user    0m1.468s
sys 0m0.056s

real    0m2.023s
user    0m1.448s
sys 0m0.080s

real    0m1.669s
user    0m1.432s
sys 0m0.088s

real    0m1.674s
user    0m1.416s
sys 0m0.104s
$for i in 1 2 3 4 5 ; do time java UsingS; done

real    0m2.344s
user    0m1.584s
sys 0m0.136s

real    0m2.057s
user    0m1.640s
sys 0m0.084s

real    0m2.112s
user    0m1.732s
sys 0m0.072s

real    0m2.482s
user    0m1.704s
sys 0m0.108s

real    0m2.134s
user    0m1.788s
sys 0m0.072s