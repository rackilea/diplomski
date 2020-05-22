import java.util.*;

class x {
        static final int testseries[] = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97 };

        public static void main(String argv[])
        {
                Vector orig = new Vector();
                for (int i = 0; i < testseries.length; ++i) orig.add(new Integer(testseries[i]));

                Vector dist = getD(orig);
                System.out.println("d min = " + getAbsD(dist) + "\tUniformity = " + getUniformity(dist));
                printVector(orig);
                printVector(dist);
                System.out.println();

                Vector v = reorder1(orig);
                dist = getD(v);
                System.out.println("d     = " + getAbsD(dist) + "\tUniformity = " + getUniformity(dist));
                printVector(v);
                printVector(dist);
                System.out.println();

                v = reorder2(orig);
                dist = getD(v);
                System.out.println("d     = " + getAbsD(dist) + "\tUniformity = " + getUniformity(dist));
                printVector(v);
                printVector(dist);
                System.out.println();

                return;
        }

        //
        // This method constructs the Distance Vector from the input
        // 
        public static Vector getD(Vector orig)
        {
                Vector v = new Vector();
                for (int i = 0; i < orig.size() - 1; ++i) {
                        int a = ((Integer) orig.get(i)).intValue();
                        int b = ((Integer) orig.get(i + 1)).intValue();
                        v.add(new Integer(Math.abs(a - b)));
                }
                return v;
        }

        public static double getAbsD(Vector orig)
        {
                double d = 0;
                Vector v = getD(orig);

                for (int i = 0; i < v.size(); ++i) {
                        int a = ((Integer) v.get(i)).intValue();
                        d += a * a;
                }
                return Math.sqrt(d);
        }

        public static double getUniformity(Vector dist)
        {
                double u = 0;
                double mean = 0;

                for (int i = 0; i < dist.size(); ++i) {
                        mean += ((Integer) dist.get(i)).intValue();
                }
                mean /= dist.size();

                for (int i = 0; i < dist.size(); ++i) {
                        int a = ((Integer) dist.get(i)).intValue();
                        u += (a - mean) * (a - mean);
                }

                return u / dist.size();
        }

        //
        // This method reorders the input vector to maximize the distance
        // It is assumed that the input is sorted (direction doesn't matter)
        //
        // Note: this is only the basic idea of the distribution algorithm
        //       in this form it only works if (n - 1) mod 4 == 0
        //
        public static Vector reorder1(Vector orig)
        {
                Integer varr[] = new Integer[orig.size()];

                int t, b, lp, rp;
                t = orig.size() - 1;
                b = 0;
                lp = t / 2 - 1;
                rp = t / 2 + 1;
                varr[t/2] = (Integer) orig.get(t); t--;
                while (b < t) {
                        varr[lp] = (Integer) orig.get(b); b++;
                        varr[rp] = (Integer) orig.get(b); b++;
                        lp--; rp++;
                        varr[lp] = (Integer) orig.get(t); t--;
                        varr[rp] = (Integer) orig.get(t); t--;
                        lp--; rp++;
                }

                Vector result = new Vector();
                for (int i = 0; i < orig.size(); ++i) result.add(varr[i]);

                return result;
        }

        //
        // This method reorders the input vector to maximize the distance
        // It is assumed that the input is sorted (direction doesn't matter)
        //
        // Note: this is only the basic idea of the distribution algorithm
        //       in this form it only works if (n - 1) mod 4 == 0
        //
        public static Vector reorder2(Vector orig)
        {
                Integer varr[] = new Integer[orig.size()];

                int t, b, lp, rp;
                t = orig.size() - 1;
                b = orig.size() / 2 - 1;
                lp = t / 2 - 1;
                rp = t / 2 + 1;
                varr[t/2] = (Integer) orig.get(t); t--;
                while (b > 0) {
                        varr[lp] = (Integer) orig.get(b); b--;
                        varr[rp] = (Integer) orig.get(b); b--;
                        lp--; rp++;
                        varr[lp] = (Integer) orig.get(t); t--;
                        varr[rp] = (Integer) orig.get(t); t--;
                        lp--; rp++;
                }

                Vector result = new Vector();
                for (int i = 0; i < orig.size(); ++i) result.add(varr[i]);

                return result;
        }

        //
        // to make everything better visible
        //
        public static void printVector(Vector v)
        {
                String sep = "";
                System.out.print("{");
                for (int i = 0; i < v.size(); ++i) {
                        System.out.print(sep + v.get(i));
                        sep = ", ";
                }
                System.out.println("}");
        }
}