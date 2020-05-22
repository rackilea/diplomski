public abstract class AbstractUIConverter<UIO, DTO> {
  protected abstract DTO toDto(final UIO input);

  protected abstract UIO toUIO(final DTO input);

  protected List<DTO> toDtoList(final List<UIO> inputList) {
    return convertList(inputList, this::toDto);
  }

  protected List<UIO> toUIOList(final List<DTO> inputList) {
    return convertList(inputList, this::toUIO);
  }

  private <I, O> List<O> convertList(final List<I> inputList, final Function<I, O> function) {
    if(inputList.isEmpty()) {
      return Collections.emptyList();
    }
    List<O> returnList = new ArrayList<>(inputList.size());
    for(I input : inputList) {
      returnList.add(function.apply(input));
    }
    return returnList;
  }
}