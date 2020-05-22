import java.util.Random;

public abstract class Harness {
    public static void main(String[] args) {
        while (true) {
            long[] randomData = new long[4096];
            Random r = new Random();
            for (int i = 0; i < randomData.length; i++) {
                randomData[i] = r.nextLong();
            }
            long[] buffer = new long[64];

            Harness[] versions = new Harness[] {
                    new Control(randomData, buffer),
                    new Carl(randomData, buffer),
                    new MarkPeters(randomData, buffer),
                    new MarkPetersServer64Bit(randomData, buffer),
//                    new Rsp1(randomData, buffer), 
                    new Rsp2(randomData, buffer),
                    new Mikera(randomData, buffer)
                    };
            for (Harness v : versions) {
                v.doTest();
            }
        }
    }

    private final long[] buffer;
    private final long[] randomData;

    protected Harness(long[] randomData, long[] buffer) {
        this.randomData = randomData;
        this.buffer = buffer;
    }

    public void doTest() {
        long start = System.nanoTime();
        long count = 0;
        for (int times = 0; times < 1000; times++) {
            for (int i = 0; i < randomData.length; i++) {
                count = decompose(buffer, randomData[i]);
            }
        }
        long end = System.nanoTime();

        //verify decomposition of last item
        long l = 0;
        for ( int i = 0; i < count; i++ ) {
            l |= buffer[i];
        }

        System.out.println(getClass().getSimpleName() + " took " + (end - start)
                / 1000000.0 + " ms - last base: " + l);
    }

    protected abstract int decompose(long[] buffer, long base);

    private static class Control extends Harness {
        protected Control(long[] randomData, long[] buffer) {
            super(randomData, buffer);
        }

        @Override
        protected int decompose(long[] buffer, long base) {
            return 0;
        }
    }

    private static class Carl extends Harness {
        protected Carl(long[] randomData, long[] buffer) {
            super(randomData, buffer);
        }

        @Override
        protected int decompose(long[] buffer, long base) {
            final int count = Long.bitCount(base);
            for (int i = 0; i < count; i++) {
                base ^= (buffer[i] = Long.lowestOneBit(base));
            }
            return count;
        }
    }

    private static class Mikera extends Harness {
        protected Mikera(long[] randomData, long[] buffer) {
            super(randomData, buffer);
        }

        @Override
        protected int decompose(long[] buffer, long base) {
            int count = 0;
            while (base != 0) {
                long mask = base & (-base);
                base &= ~mask;
                buffer[count++] = mask;
            }
            return count;
        }
    }

    private static class Rsp1 extends Harness {
        protected Rsp1(long[] randomData, long[] buffer) {
            super(randomData, buffer);
        }

        @Override
        protected int decompose(long[] buffer, long base) {
            int count = 0;

            if (0 != (base & 1)) {
                buffer[count++] = 1;
            }

            base >>>= 1;

            for (long bit = 1; 0 < bit && bit <= base; ) {
                if (0 < (base & bit)) {
                    buffer[count++] = (bit <<= 1);
                }
            }
            return count;
        }
    }

    private static class Rsp2 extends Harness {
        protected Rsp2(long[] randomData, long[] buffer) {
            super(randomData, buffer);
        }

        @Override
        protected int decompose(long[] buffer, long base) {
            int count = 0;

            for (long bit = 1; 0 != base; bit <<= 1, base >>>= 1) {
                if (0 < (base & 1)) {
                    buffer[count++] = bit;
                }
            }
            return count;
        }
    }

    private static class MarkPeters extends Harness {
        protected MarkPeters(long[] randomData, long[] buffer) {
            super(randomData, buffer);
        }

        @Override
        protected int decompose(long[] buffer, long base) {
            int count = Long.bitCount(base);
            for (int i = 0; i < count; i++) {
                base -= (buffer[i] = Long.lowestOneBit(base));
            }
            return count;

        }
    }

    private static class MarkPetersServer64Bit extends Harness {
        protected MarkPetersServer64Bit(long[] randomData, long[] buffer) {
            super(randomData, buffer);
        }

        @Override
        protected int decompose(long[] buffer, long base) {
            int count = 0;
            while ( 0 != (base ^= (buffer[count++] = Long.lowestOneBit(base))));
            return count;
        }
    }
}