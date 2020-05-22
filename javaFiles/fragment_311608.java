double[] ds = new double[17];
ds[0] = 1e-4;
for (int i = 1; i < ds.length; i++)
    ds[i] = 2 * ds[i - 1];

DoubleStream.of(ds).parallel()
        .forEach(x -> {
            int counter = 0;
            for (double d = x; d <= 2 * x && d < 9.99995; d += Math.ulp(d)) {
                if (Double.toString(Maths.round4(d)).length() > 6)
                    fail("d: " + d);
                if ((counter & 127) == 0 && counter % 10_000_000 == 0)
                    System.out.println(d);
                counter++;
            }
        });