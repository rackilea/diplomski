public abstract class AbstractUIConverter<UIO, DTO> {
  protected abstract DTO toDto(final UIO input);

  protected abstract UIO toUIO(final DTO input);

  protected List<DTO> toDtoList(final List<UIO> inputList) {
    return convertList(inputList, new Function<UIO, DTO>() {
      @Override
      public DTO apply(UIO input) {
        return AbstractUIConverter.this.toDto(input);
      }
    });
  }

  protected List<UIO> toUIOList(final List<DTO> inputList) {
    return convertList(inputList, new Function<DTO, UIO>() {
      @Override
      public UIO apply(DTO input) {
        return AbstractUIConverter.this.toUIO(input);
      }
    });
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