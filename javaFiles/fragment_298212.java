public class NewsAdapter extends ArrayAdapter<Articles_Map> {
  private static final Comparator<Articles_Map> 
    byPublishedAtComparetor = new Comparator<Articles_Map>() {
        public int compare(Articles_Map o1, Articles_Map o2) {
          // Improve this to handle null publishedAt
          return o1.getPublishedAt().compareTo(o2.getPublishedAt());
        }
      }
    ;

  Context mContext;

  // snip...


  public NewsAdapter(Context c, int resource, List<Articles_Map> articles) {
    super(c, resource, articles);
    this.sort(byPublishedAtComparetor);
    this.mContext = c;
  }


  protected void doAdd(Articles_Map another) {
    suoer.add(another);
  }

  // Override to maintain the order
  void add(Articles_Map another) {
    this.doAdd(another);
    this.sort(byPublishedAtComparator);
  }
  // Overrides to maintain order and to avoid calling into
  // individual add(...) method, which will cause unnecessary
  // sorting after each element
  @Override
  public void addAll(Articles_Map... others) {
    for(Articles_Map a : others) {
      this.doAdd(a);
    }
    this.sort(byPublishedAtComparator);
  }

  @Override
  public void addAll(Collection<Articles_Map> others) {
    for(Articles_Map a : others) {
      this.doAdd(a);
    }
    this.sort(byPublishedAtComparator);
  }

  @Override
  public void insert(int i, Articles_Map article) {
    // decline to insert it at any indicated position
    // as it may break the order. Instead, treat it as any addition
    // which will automatically result in a reordering
    this.add(article);
  }

  // No override for remove - removing elements don't break
  // the order