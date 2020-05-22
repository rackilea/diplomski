Function<String, Integer> f =
    (String t) -> {
        try {
           return myMethod(t);
        }
        catch(IOException e) {
            throw new UncheckedIOException(e);
        }
    };