Map<CarRange,List<Car>> map = 
            ranges.stream()
                .collect(
                    Collectors.toMap(
                        range -> range, 
                        range -> cars.stream()
                            .filter(car -> range.carInRange(car))
                            .collect(Collectors.toList())
                    )
                );