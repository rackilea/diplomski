Random rn = new Random();
        int a, b, c, d;

        int min = 3, max = 10;
        int desired = 30;
        while
            (
            (
            (a = rn.Next(min, max))
            + (b = rn.Next(min, max))
            + (c = rn.Next(min, max))
            + (d = rn.Next(min, max))
            )
            != desired
            ) { }

        int x = rn.Next(-1* (a - 1 ), a - 1);
        int y = rn.Next(-1 * (b - 1), b - 1);
        int z = rn.Next(-1 * (c - 1), c - 1);
        int v = rn.Next(-1 * (d - 1), d - 1);

        string result =
            (x >= 0 ? (a - x) + "+" + x : (a + -1 * x) + "-" + -1 * x) + " + " +
            (y >= 0 ? (b - y) + "+" + y : (b + -1 * y) + "-" + -1 * y) + " + " +
            (z >= 0 ? (c - z) + "+" + z : (c + -1 * z) + "-" + -1 * z) + " + " +
            (v >= 0 ? (d - v) + "+" + v : (d + -1 * v) + "-" + -1 * v);