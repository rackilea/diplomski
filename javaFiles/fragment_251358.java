firstLevelList.stream().flatMap(FirstLevelElement::getSecondLevelStream);

class FirstLevelElement {

    Stream<String> getSecondLevelStream() {
        return this.getSecondLevelList().stream().flatMap(SecondLevelElement::getThirdLevelStream);
    }

    Collection<SecondLevelElement> getSecondLevelList() {...}
}

class SecondLevelElement {

    Stream<String> getThirdLevelStream() {
        return this.getThirdLevelList().stream().map(Object::toString);
    }

    Collection<ThirdLevelElement> getThirdLevelList() {...}
}