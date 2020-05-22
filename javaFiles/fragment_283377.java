public class Valuation {

    public static class Element implements Comparable<Element> {
        String valuation;
        String data;
        Element(String v, String d) {
            valuation = v;
            data = d;
        }
        @Override
        public int compareTo(Element e) {           
            return valuation.compareTo(e.valuation);
        }       
    }

    private TreeSet<Element> ts = new TreeSet<Element>();

    private final static int LISTLENGTH = 500;

    public static void main(String[] args) {
        NumberFormat nf = new DecimalFormat("00000");
        Random r = new Random();
        Valuation v = new Valuation();
        for(long l = 1; l < 150; ++l) {
            long start = System.currentTimeMillis();
            for(int j = 0; j < 10000; ++j) {
                v.pushNew(new Element(nf.format(r.nextInt(50000))
                                , UUID.randomUUID().toString()));
            }
            System.out.println("10.000 finished in " + (System.currentTimeMillis()-start) + "ms. Set contains: " + v.ts.size());
        }
        for(Element e : v.ts) {
            System.out.println("-> " + e.valuation);
        }
    }

    private void pushNew(Element hexString) {
        if(ts.size() < LISTLENGTH) {
            ts.add(hexString);
        } else {
            if(ts.first().compareTo(hexString) < 0) {
                ts.add(hexString);
                if(ts.size() > LISTLENGTH) {
                    ts.remove(ts.first());
                }
            }
        }
    }
}