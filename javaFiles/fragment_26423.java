public class Chmod {

        public Set<PosixFilePermission> fromInt(int perms) {
            final char[] ds = Integer.toString(perms).toCharArray();
            final char[] ss = {'-','-','-','-','-','-','-','-','-'};
            for (int i = ds.length-1; i >= 0; i--) {
                int n = ds[i] - '0';
                if (i == ds.length-1) {
                    if ((n & 1) != 0) ss[8] = 'x';
                    if ((n & 2) != 0) ss[7] = 'w';
                    if ((n & 4) != 0) ss[6] = 'r';
                }
                else if (i == ds.length-2) {
                    if ((n & 1) != 0) ss[5] = 'x';
                    if ((n & 2) != 0) ss[4] = 'w';
                    if ((n & 4) != 0) ss[3] = 'r';
                }
                else if (i == ds.length-3) {
                    if ((n & 1) != 0) ss[2] = 'x';
                    if ((n & 2) != 0) ss[1] = 'w';
                    if ((n & 4) != 0) ss[0] = 'r';
                }
            }
            String sperms = new String(ss);
            System.out.printf("%d -> %s\n", perms, sperms);
            return PosixFilePermissions.fromString(sperms);
        }

        public static void main(String[] args) throws Exception {
            Chmod test = new Chmod();
            test.fromInt(444);
            test.fromInt(1);
            test.fromInt(777);
            test.fromInt(666);
            test.fromInt(604);
            test.fromInt(0);
        }

    }