output = getOutput();
emptyIfNull(getConverters())
    .stream()
    .map(GenericConverterBase::getInput)
    .filter(Objects::nonNull)
    .forEach(input -> output = input.apply(output)); // here I suppose you will need to provide casting to O
return output;