List<AnimalVO> list = herd.stream()
    .filter(Objects::nonNull)
    .map(a -> Optional.ofNullable(a.getGoat())
        .map(Goat::getGoatField)
        .<AnimalVO>map(GoatVO::new)
        .orElseGet(() -> new SheepVO(a.getSheep().getSheepField())))
    .collect(Collectors.toList());