public class YourCustomPagingLoadResultBean extends PagingLoadResultBean<Data> {

  protected YourCustomPagingLoadResultBean () {
  }

  public YourCustomPagingLoadResultBean (List<Data> list, int totalLength, int offset) {
    super(list, totalLength, offset);
  }
}