enum Tests {
    A_gt_5 {
        @Override
        boolean test(int a, int b, int c) {
            return a > 5;
        }
    },
    B_gt_7 {
        @Override
        boolean test(int a, int b, int c) {
            return b > 7;
        }
    },
    C_gt_13 {
        @Override
        boolean test(int a, int b, int c) {
            return c > 13;
        }
    };

    abstract boolean test (int a, int b, int c);
}

public void test(int a, int b, int c) {
    boolean good = true;
    for ( Tests t : Tests.values() ) {
        good = good && t.test(a, b, c);
        if (!good) {
            break;
        }
    }
    if (!good) {
        System.out.println("I don't like your variables");
    }
}