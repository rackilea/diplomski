obj2Arr = obj2Arr.stream()
        .filter(anObjOf2 -> carIdToId.containsKey(anObjOf2.getCarId()))
        .peek(anObjOf2 -> anObjOf2.setId(carIdToId.get(anObjOf2.getCarId())))
        .collect(Collectors.toList());
System.out.println(obj2Arr);
// [Car(id=2, carId=1234)]