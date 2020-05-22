TreeMap<Double, List<List<Integer>>> x = locations.stream().collect(
            Collectors.groupingBy((List<Integer> b) -> {
                        double d = b.stream().mapToDouble(i -> i.doubleValue()).sum();
                        return Math.sqrt(d);
                    },
                    TreeMap::new,
                    Collectors.toList()));