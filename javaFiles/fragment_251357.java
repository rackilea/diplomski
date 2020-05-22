firstLevelList.stream().flatMap(
        firstLevelElement -> firstLevelElement.getSecondLevelList().stream().flatMap(
                secondLevelElement -> getThirdLevelStream(secondLevelElement)
        )
);

Stream<String> getThirdLevelStream(SecondLevelElement secondLevelElement) {
    return secondLevelElement.getThirdLevelList().stream().map(Object::toString);
}