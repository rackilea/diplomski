Map<String, DataCar> result =
    carMileage.entrySet()
              .stream()
              .collect(Collectors.toMap(
                Map.Entry::getKey,
                e -> new DataCar(e.getValue(), carGearBox.get(e.getKey()), carMaxSpeed.get(e.getKey()))
              ));