int[] substract(int[] a, int[] b) {
        return IntStream.range(0, Math.max(a.length, b.length))
                .map(i -> {
                    if(i < a.length && i < b.length)
                        return a[i] - b[i];
                    if(i < a.length)
                        return a[i];
                    return b[i];
                })
                .toArray();
    }