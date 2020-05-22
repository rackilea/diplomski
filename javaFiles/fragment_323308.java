return Ordering.onResultOf(new Function<String, String>() {
            @Override
            public String apply(String input) {
                return input.getBytes().toString();
            }
        })
        .nullsFirst()
        .compare(x, y);