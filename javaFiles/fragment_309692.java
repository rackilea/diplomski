System.out.println(Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
            .parallel()
            .reduce(new ImmutableAverager(), 
                    ImmutableAverager::accept,
                    ImmutableAverager::combine)
            .average());