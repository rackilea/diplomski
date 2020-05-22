String word = stream1.reduce(
            "",
            (x, y) -> {
                x.concat(y);
                return x; // kind of stupid, but you could
            },
            (x, y) -> {
                return x.concat(y);
            });