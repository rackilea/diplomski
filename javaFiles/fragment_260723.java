public static void main(final String[] args) {
    for (long i = -2000; i <= 2000; i++) {
        final long pi = i * i * i;
        if ((i > 0) && (pi > 100)) {
            break;
        }
        for (long j = i; j <= 2000; j++) {
            final long pj = pi + (j * j * j);
            if ((j > 0) && (pj > 100)) {
                break;
            }
            for (long k = j; k <= 2000; k++) {
                final long pk = pj + (k * k * k);
                if ((k > 0) && (pk > 100)) {
                    break;
                }

                if (pk == 100) {
                    System.out.println(i + " " + j + " " + k);
                }
            }
        }
    }
}