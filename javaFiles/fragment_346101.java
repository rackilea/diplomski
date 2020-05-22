List<Long> numbers = Arrays.asList(2L, 2L, 4L, 5L);
List<Pair> results = numbers.stream()
        .collect(ArrayList::new, (sums, number) -> {
            if (sums.isEmpty()) {
                sums.add(new Pair(number, number));
            } else {
                sums.add(new Pair(number, number + sums.get(sums.size() - 1).getSum()));
            }
        }, (sums1, sums2) -> {
            if (!sums1.isEmpty()) {
                long sum = sums1.get(sums1.size() - 1).getSum();
                sums2.forEach(p -> p.setSum(p.getSum() + sum));
            }
            sums1.addAll(sums2);
        });