String word = stream1.reduce(
            "",
            (x, y) -> {
                return x.concat(y);
            },
            (x, y) -> {
                return x.concat(y);
            });