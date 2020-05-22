Map<String, List<Car>> mostExpensivesAndCheapest = carsDetails.stream()
    .collect(Collectors.toMap(Car::getMake, car -> Arrays.asList(car, car),
        (l1,l2) -> Arrays.asList(
            (l1.get(0).getPrice()>l2.get(0).getPrice()? l2: l1).get(0),
            (l1.get(1).getPrice()<l2.get(1).getPrice()? l2: l1).get(1))));
mostExpensivesAndCheapest.forEach((make,cars) -> System.out.println(make
        +" cheapest: "+cars.get(0)+" most expensive: "+cars.get(1)));