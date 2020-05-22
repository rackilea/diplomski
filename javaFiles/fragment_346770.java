MyObject[] array = Files.lines(path)
                        .map(s -> s.split("\\s+", 2))
                        .map(a -> new MyObject(a[0], a[1]))
                        .toArray(MyObject[]::new);

System.out.println(Arrays.toString(array));