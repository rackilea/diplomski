// Minimal example for which the JVM does not scalarize the allocation. If field is final, or the second allocation is unconditional, it will.

class Scalarization {

        int field = 0xbd;
        long foo(long i) { return i * field; }


        public static void main(String[] args) {
                long result = 0;
                for(long i=0; i<100; i++) {
                        result += test();
                }
                System.out.println("Result: "+result);
        }


        static long test() {
                long ctr = 0x5;
                for(long i=0; i<0x10000; i++) {

                Scalarization s = new Scalarization();
                ctr = s.foo(ctr);
                if(i == 0) s = new Scalarization();
                ctr = s.foo(ctr);
                }
                return ctr;
        }
}