int[] array = Arrays.stream(values)
                    .map(i -> Arrays.stream(i)
                                    .boxed()
                                    .collect(Collectors.summingInt(j -> j)))
                    .mapToInt(i -> i)
                    .toArray();