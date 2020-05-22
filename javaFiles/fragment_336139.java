int[] result = carDealer.getBrands()
         .stream()
         .map(brand -> new int[]{brand.getManufacturer().getIncome(),
                                 brand.getManufacturer().getOutcome()})
         .collect(Collector.of(
                    () -> new int[2],
                    (left, right) -> {
                        left[0] += right[0];
                        left[1] += right[1];
                    },
                    (left, right) -> {
                        left[0] += right[0];
                        left[1] += right[1];
                        return left;
                    }));