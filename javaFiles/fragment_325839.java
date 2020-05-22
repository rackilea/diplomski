Map<String, SimpleEntry<Double, Double>> map = Stream.of(new TimePeriodCalc(12d, 10d, "A"), new TimePeriodCalc(2d, 16d, "A"))
            .collect(Collectors.groupingBy(TimePeriodCalc::getAtDate,
                    Collectors.collectingAndThen(Collectors.toList(), list -> {
                        double occupancy = list.stream().collect(
                                Collectors.averagingDouble(TimePeriodCalc::getOccupancy));
                        double efficiency = list.stream().collect(
                                Collectors.averagingDouble(TimePeriodCalc::getEfficiency));
                        return new AbstractMap.SimpleEntry<>(occupancy, efficiency);
                    })));

    System.out.println(map);