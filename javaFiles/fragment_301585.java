public class PagingOptions {

  private int mPage;

  private int mLimit;

  public PagingOptions(int page, int limit)
  {
    mPage = page;
    mLimit = limit;
  }

  public int getPage() {
    return mPage;
  }

  public void setPage(int mPage) {
    this.mPage = mPage;
  }

  public int getLimit() {
    return mLimit;
  }

  public void setLimit(int mLimit) {
    this.mLimit = mLimit;
  }
}