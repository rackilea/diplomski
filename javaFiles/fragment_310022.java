return userRepo
    .findAll()
    .stream()
    .filter(user -> active == null || user.getIsActive() == active.booleanValue())
    .filter(user -> eyeColor == null || user.getEyeColor().equalsIgnoreCase(eyeColor))
    .filter(user -> user.getBalance() >= balance.doubleValue())
    .filter(user -> age == 0 || user.getAge() >= age)
    .filter(user -> zipCode == 0 || user.getAddress().getZip() == zipCode)
    .collect(Collectors.toList());