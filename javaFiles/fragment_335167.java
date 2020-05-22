public class dn09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();
        int d = sc.nextInt();
        Tip[] tipi = preberi(sc);
        int u = sc.nextInt();
        int[] ukazi = new int[u];
        for (int i = 0; i < u; i++) {
            ukazi[i] = sc.nextInt(); //if you know a better way to store 2 numbers where i could then
            //use the numbers separately that would be super helpfull as id
        }                            //need it for 2 switch statements which im currenty trying to
        for (int i = 0; i < u; i++) {//fit into 1.
            switch(ukazi[i]) {
                case 11:
                    break;
...
            }
        }
    }

    public Tip[] preberi(Scanner sc) {
        Tip[] tipi = new tipi[d];
        for (int i = 0; i < tipi.length; i++) {
            String tip = sc.next();
            switch (tip) {
                case "prim":
                    liki[i] = new Prim(sc.nextInt());
                    break;
...
            }
        }
        return tipi;
    }

    private static class Prim extends dn09 {
        protected int v;
        public Prim (int v) {
            this.v = v;
        }
    }

    private static class Arr extends dn09 {
        protected int n;
        protected int t;
        public Arr (int n, int t) {
            this.t = t;
            this.n = n;
        }
    }
}