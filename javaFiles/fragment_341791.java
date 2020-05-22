class Baap {  
    public int h = 4;  
    public int getH() { System.out.println("Baap    "+h); return h; }  
}  

class Beta extends Baap {
    public int h = 44;
    public int getH() { System.out.println("Beta    "+h); return h; }

    public static void main(String[] args) {
        Baap b = new Beta();
        System.out.println(b.h + "    " + b.getH());
        /* The string concatenation gets compiled to:
         * new StringBuffer().append(b.h).append("    ").append(b.getH()).toString();
         *                             \ This is Baap.h         \ This prints Beta 44 and returns 44 from Beta.h
         */
        // Printed "Beta 44" from b.getH().
        // Printed "4    44" from statements concatenation.
        Beta bb = (Beta) b;  
        System.out.println(bb.h + "   " + bb.getH());
        /* The string concatenation gets compiled to:
         * new StringBuffer().append(bb.h).append("    ").append(bb.getH()).toString();
         *                             \ This is Beta.h          \ This prints Beta 44 and returns 44 from Beta.h
         */
        // Printed "Beta 44" from b.getH().
        // Printed "44    44" from statements concatenation.
    }
}