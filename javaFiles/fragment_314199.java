long result = Stream.of(1, 2, 3, 4, 5)
            .mapToInt(x -> {
                System.out.println("mapping");
                return x;
            })
            .count();

System.out.println(result);