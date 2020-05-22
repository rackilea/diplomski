Function<String, Integer> f = s -> {
        int first = s.charAt(0) * 2 + s.charAt(1);
        int total = first;

        for (int x = 1; x < s.length() - 1; x++) {
            total = total * 2 + s.charAt(x + 1);
        }

        return total;

    };