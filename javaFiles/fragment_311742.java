class T {
        final int i;
        final int c;

        public T(int i, int c) {

            this.i = i;
            this.c = c;
        }
    }
    int[] i = {0};


    String res = "123456789".chars()
            .mapToObj(c -> new T(i[0]++, c))
            .collect(Collectors.groupingBy(x -> x.i / 3))
            .entrySet()
            .stream()
            .sorted(Comparator.comparing(Map.Entry::getKey))
            .map(x ->
                    x.getValue().stream().mapToInt(y -> y.c)
                            .mapToObj(y -> String.valueOf((char)y))
                            .collect(Collectors.joining())

            ).collect(Collectors.joining("-"));


    System.out.println("res = " + res);